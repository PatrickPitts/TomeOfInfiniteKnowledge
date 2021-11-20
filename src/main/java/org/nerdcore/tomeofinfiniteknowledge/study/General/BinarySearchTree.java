package org.nerdcore.tomeofinfiniteknowledge.study.General;

import java.util.*;

public class BinarySearchTree<E> extends AbstractSet<E> {

    protected Entry<E> root;
    protected int size;

    /**
     * Default Constructor. No initial elements, all future elements of type E, no duplicates,
     * uses the Comparable interface to implement ordering
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Copy Constructor
     */
    public BinarySearchTree(BinaryTree<? extends E> otherTree) {

    }

    /**
     * Returns an iterator positioned at the smallest element in this BinarySearchTree
     *
     * @return iterator positioned at the smallest element in this BinarySearchTree, as determined
     * through the Comparable interface.
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /**
     * Returns the size of the BinarySearchTree object
     *
     * @return size of the BinarySearchTree
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Determines if there is an Object in this BinarySearchTree that is equal to obj
     * worstTime(n) = O(n), best time is O(log(n))
     * <p>
     * Code that was originally included in this method has been re-encapsulated in the getEntry() method
     *
     * @param obj - element sought after in this BinarySearchTree
     * @return true - if there is an object in this BinarySearchTree that is equal to obj, returns false otherwise
     * @throws ClassCastException   - if obj is not null but cannot be compared to the elements already in this BinarySearchTree.
     * @throws NullPointerException - if obj is null
     */
    public boolean contains(Object obj) {
        return getEntry(obj) != null;
    }

    /**
     * Adds element to this BinarySearchTree, ensuring it is present.
     *
     * @param element - the element to be added to this BinarySearchTree
     * @return true - if the element was correctly inserted into this BinarySearchTree, returns false otherwise.
     * @throws ClassCastException   - if element is not null but cannot be compared to the elements in this BinarySearchTree
     * @throws NullPointerException - if element is null
     */
    public boolean add(E element) {
        if (element == null) throw new NullPointerException();
        if (root == null) root = new Entry<E>(element, null);
        int comp;
        Entry<E> temp = root;
        while (true) {
            // element - temp; subtraction
            comp = ((Comparable) element).compareTo(temp.element);
            if (comp == 0) return false;
            else {
                if (comp < 0) {
                    if (temp.left == null) {
                        temp.left = new Entry<E>(element, temp);
                        size++;
                        return true;
                    } else temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = new Entry<E>(element, temp);
                        size++;
                        return true;
                    } else temp = temp.right;
                }
            }
        }
    }


    /**
     * Removes an object from this BinarySearchTree, ensuring it is absent
     *
     * @param obj - the object to be removed from the BinarySearchTree
     * @return true - if this BinarySearchTree is altered by this method call, returns false otherwise
     * @throws ClassCastException   - if obj is not null but cannot be compared to the elements in this BinarySearchTree
     * @throws NullPointerException - if obj is null
     */
    public boolean remove(Object obj) {
        Entry<E> e = getEntry(obj);
        if (e == null) return false;
        deleteEntry(e);
        return true;
    }

    protected Entry<E> getEntry(Object obj) {
        int comp;
        if (obj == null) throw new NullPointerException();
        Entry<E> e = root;
        //searches while viable search elements still exists
        while (e != null) {
            //performs comparison.
            // obj - temp, essentially subtraction
            comp = ((Comparable) obj).compareTo(e.element);
            //obj is "equal" to temp, return true
            if (comp == 0) return e;
                //obj is "smaller" than temp, we need to find a smaller contender Entry
            else if (comp < 0) e = e.left;
                //obj is "larger" than temp, we need to find a larger contender Entry
            else e = e.right;
        } //there are no longer any viable contender Entrys that could equal obj
        return null;
    }

    /**
     * Deletes the element in a specified entry object from this BinarySearchTree
     *
     * @param p - the Entry objet whose element is to be deleted from this BinarySearchTree object
     * @return the Entry object that was deleted from this BinarySearchTree
     */
    protected Entry<E> deleteEntry(Entry<E> p) {
        size--;
        //p has two children
        if (p.left != null && p.right != null) {
            Entry<E> s = successor(p);
            p.element = s.element;
            p = s;
        }
        Entry<E> replacement;
        if (p.left != null) {
            replacement = p.left;
        } else replacement = p.right;

        if (replacement != null) {
            replacement.parent = p.parent;
            if (p.parent == null) {
                root = replacement;
            } else if (p == p.parent.left) {
                p.parent.left = replacement;
            } else {
                p.parent.right = replacement;
            }
        } else if (p.parent == null) {
            root = null;
        } else {
            if (p == p.parent.left) p.parent.left = null;
            else p.parent.right = null;
        }
        return p;
    }

    protected Entry<E> successor(Entry<E> e) {
        if (e == null) return null;
        else if (e.right != null) {
            Entry<E> p = e.right;
            while (p.left != null) p = p.left;
            return p;
        } else {
            Entry<E> p = e.parent, ch = e;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }
    protected void rotateRight(Entry<E> p) {
        Entry<E> l = p.left;
        p.left = l.right;
        if(l.right != null) l.right.parent = p;
        l.parent = p.parent;
        if (p.parent == null) root = l;
        else if(p.parent.right == p) p.parent.right = l;
        else p.parent.left = l;
        l.right = p;
        p.parent = l;
    }

    protected void rotateLeft(Entry<E> p) {
        Entry<E> r = p.right;
        p.right = r.left;
        if (r.left != null) r.left.parent = p;
        r.parent = p.parent;
        if (p.parent == null) root = r;
        else if (p.parent.left == p) p.parent.left = r;
        else p.parent.right = r;
        r.left = p;
        p.parent = r;
    }

    public void printLevels(){
        Queue<Entry<E>> Q = new LinkedList<>();
        Q.add(root);
        while(Q.size() > 0){

        }
    }

    protected static class Entry<E> {
        protected E element;
        protected Entry<E> left = null, right = null, parent;

        public Entry() {
        }

        public Entry(E element, Entry<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    protected class TreeIterator implements Iterator<E> {
        protected Entry<E> lastReturned = null, next;

        protected TreeIterator() {
            next = root;
            if (next != null) {
                while (next.left != null) {
                    next = next.left;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if (next == null) throw new NoSuchElementException();
            lastReturned = next;
            next = successor(next);
            return lastReturned.element;
        }

        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            if (lastReturned.left != null && lastReturned.right != null) {
                next = lastReturned;
            }
            deleteEntry(lastReturned);
            lastReturned = null;
        }
    }
}
package org.nerdcore.tomeofinfiniteknowledge.study.General;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> implements Serializable {
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;


    /**
     * Constructor - creates a BinaryTree with a single leaf, no branches or child nodes
     * @param data - value of root node
     */
    public BinaryTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructor - recursively creates a binary tree based on the data data in the input array. The input array
     * represents the tree by levels; in this organization, for an element at index i, its child nodes' data will be
     * at index 2i + 1 and 2i + 2.
     * @param data - the data to fill in the BinaryTree
     */
    public BinaryTree(T[] data) {
        if (verifyArray(data)) {
            this.data = data[0];
            this.attachLeft(build(data, 1));
            this.attachRight(build(data, 2));
        }
    }

    /**
     * Verifies that the input array will create a valid BinaryTree if used correctly.
     * It checks every index such that, if value at the index is not null, there is a viable parent entry at the
     * correct parent index.
     * @param data - the values to be incorporated in the BinaryTree
     * @return - true if each element has a viable parent element, otherwise false.
     */
    private boolean verifyArray(T[] data) {
        if (data.length == 0 || data[0] == null) return false;
        for (int i = 1; i < data.length; i++) {
            if(data[i] == null)continue;
            if ((i % 2 == 0 && data[(i - 2) / 2] == null) || data[(i - 1) / 2] == null) return false;
        }
        return true;
    }

    /**
     * The actual build method called by a Constructor. Called recursively, this method returns the tree that will be
     * the child of the previous recursive call.
     * @param data - the total array of data to be used for the entire BinaryTree
     * @param i - the index that this node uses for reference.
     * @return - the built up sub-BinaryTree
     */
    private BinaryTree<T> build(T[] data, int i) {
        if (i >= data.length || data[i] == null) return null;
        BinaryTree<T> root = new BinaryTree<>(data[i]);
        root.attachLeft(build(data, 2 * i + 1));
        root.attachRight(build(data, 2 * i + 2));
        return root;
    }

    /**
     * @return - the data value of this node
     */
    public T getData() {
        return data;
    }

    /**
     * Attaches a BinaryTree as a child tree as the left node to this BinaryTree
     * @param tree - the BinaryTree to be attached to the left.
     */
    public void attachLeft(BinaryTree<T> tree) {
        if (tree != null) {
            this.left = tree;
        }
    }

    /**
     * Attaches a BinaryTree as a child tree as the right node to this BinaryTree
     * @param tree - the BinaryTree to be attached to the right.
     */
    public void attachRight(BinaryTree<T> tree) {
        if (tree != null) {
            this.right = tree;
        }
    }

    /**
     * Removes the left child node from this BinaryTree. In all likelihood, that node and all child nodes will be
     * garbage collected if not assigned a new variable.
     * @return - the left BinaryTree child subtree
     */
    public BinaryTree<T> detachLeft() {
        BinaryTree<T> t = this.left;
        this.left = null;
        return t;
    }
    /**
     * Removes the right child node from this BinaryTree. In all likelihood, that node and all child nodes will be
     * garbage collected if not assigned a new variable.
     * @return - the right BinaryTree child subtree
     */
    public BinaryTree<T> detachRight() {
        BinaryTree<T> t = this.right;
        this.right = null;
        return t;
    }

    /**
     * Verifies that this BinaryTree has no data
     * @return - true if his BinaryTree has no data, otherwise false
     */
    public boolean isEmpty() {
        return this.data == null;
    }

    /**
     * Prints to the console the values of this BinaryTree by level
     */
    public void printLevels() {
        Queue<BinaryTree<T>> Q = new LinkedList<>();
        Q.add(this);
        while (Q.size() > 0) {
            int n = Q.size();
            while (n-- > 0) {
                BinaryTree<T> BT = Q.poll();
                System.out.print("" + BT.getData().toString() + ", ");
                if (BT.left != null) {
                    Q.add(BT.left);
                }
                if (BT.right != null) {
                    Q.add(BT.right);
                }
            }
            System.out.println();
        }
    }

    /**
     * Recursively prints the values of this BinaryTree in the In-Order pattern. Implemented internally to avoid
     * overly complex method calls outside this object.
     * @param tree - the BinaryTree whose value should be printed, and whose subtrees should be printed
     */
    private void inOrder(BinaryTree<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.getData());
            System.out.print(", ");
            inOrder(tree.right);
        }
    }
    /**
     * External facing In-Order print method. Avoids the need for the user to pass in parameters to the method call,
     * unlike the recursive method.
     */
    public void inOrder(){
        System.out.println("Printing In Order Traversal");
        inOrder(this);
        System.out.println();
    }

    public List<T> inOrderArrayList(){
        System.out.println("Building In Order Traversal Array");
        List<T> ret = new ArrayList<>();
        inOrderArrayList(this, ret);
        return ret;
    }
    private void inOrderArrayList(BinaryTree<T> root, List<T> arr){
        if(root == null)return;
        inOrderArrayList(root.left, arr);
        arr.add(root.getData());
        inOrderArrayList(root.right, arr);
    }

    /**
     * Recursively prints the values of this BinaryTree in the Pre-Order pattern. Implemented internally to avoid
     * overly complex method calls outside this object.
     * @param tree - the BinaryTree whose value should be printed, and whose subtrees should be printed
     */
    private void preOrder(BinaryTree<T> tree) {
        if (tree != null) {
            System.out.print(tree.getData());
            System.out.print(", ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * External facing Pre-Order print method. Avoids the need for the user to pass in parameters to the method call,
     * unlike the recursive method.
     */
    public void preOrder(){
        System.out.println("Printing Pre-Order Traversal");
        preOrder(this);
        System.out.println();
    }

    /**
     * Recursively prints the values of this BinaryTree in the Post-Order pattern. Implemented internally to avoid
     * overly complex method calls outside this object.
     * @param tree - the BinaryTree whose value should be printed, and whose subtrees should be printed
     */
    private void postOrder(BinaryTree<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.getData());
            System.out.print(", ");
        }
    }

    /**
     * External facing Post-Order print method. Avoids the need for the user to pass in parameters to the method call,
     * unlike the recursive method.
     */
    public void postOrder(){
        System.out.println("Printing Post-Order Traversal");
        postOrder(this);
        System.out.println();
    }

    private int getSize(BinaryTree<T> root){
        if(root == null)return 0;
        return getSize(root.left) + getSize(root.right) + 1;
    }

    public int getSize(){
        if(this.data == null)return 0;
        return getSize(left) + getSize(right) + 1;
    }

    @Override
    public String toString() {
        if(data == null)return null;
        return data.toString();
    }
}
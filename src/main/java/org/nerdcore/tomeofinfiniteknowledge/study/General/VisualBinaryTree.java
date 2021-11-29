package org.nerdcore.tomeofinfiniteknowledge.study.General;

import javafx.scene.Group;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VisualBinaryTree<T> extends BinaryTree<T>{

    Group visualNode;

    public Group getVisualNode() {
        return visualNode;
    }

    public void setVisualNode(Group visualNode) {
        this.visualNode = visualNode;
    }
    public VisualBinaryTree(T data) {
        super(data);
    }

    public VisualBinaryTree(T[] data) {
        super(data);
    }

    public void relocate(double x, double y){
        visualNode.relocate(x, y);
    }

    public Group[] getVisualNodeArray(){
        List<Group> ret = new ArrayList<>();
        Queue<VisualBinaryTree<T>> Q = new LinkedList<>();
        Q.add(this);


        return ret.toArray(new Group[0]);
    }
}

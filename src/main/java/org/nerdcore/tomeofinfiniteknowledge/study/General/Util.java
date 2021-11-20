package org.nerdcore.tomeofinfiniteknowledge.study.General;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Util {

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<Integer> arr = bt.inOrderArrayList();
        System.out.println(arr);
    }

    public static Integer[] inOrderTree(Integer[] tree) {
        Integer[] ret = new Integer[tree.length];
        Queue<Integer> Q = new LinkedList<>();
        int layer = 0, i = 0;
        int max_layer = (int) Math.ceil(Math.log(tree.length) / Math.log(2));
        while (layer < max_layer) {
            int num_elements_in_layer = (int) Math.pow(2, layer);
            for (int j = 0; j < num_elements_in_layer && j < tree.length; j++) {
                Q.add(tree[j + num_elements_in_layer - 1]);
            }
            for(Integer I : Q){
                ret[i++] = I;
            }
            layer++;
        }
        return ret;
    }

    private static Integer[] inOrderTree(Integer[] tree, Integer[] ret, int i, int j) {
        //i = tree pointer, j = ret pointer
        if (2 * i + 1 > tree.length) {
            ret[j++] = tree[i];
        }

        return ret;
    }


}

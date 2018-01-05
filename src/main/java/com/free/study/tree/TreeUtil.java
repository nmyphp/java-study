package com.free.study.tree;

import java.util.Stack;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2018/1/5
 */
public class TreeUtil {

    /**
     * <b>构造一个二叉树<b/>
     * <pre><pre/>
     *     A
     *    /\
     *   B  C
     *  /\   \
     * D  E   F
     * @return
     */
    public static TreeNode buid() {
        TreeNode root = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeC.setRightChild(nodeF);
        return root;

    }
}

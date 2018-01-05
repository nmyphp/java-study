package com.free.study.tree;

import java.util.Stack;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2018/1/5
 */
public class PrintTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buid();
        System.out.println("先序输出：");
        previousOrderPrintByRecursion(root);
        System.out.println("中序输出：");
        middleOrderPrintByRecursion(root);
        System.out.println("后续输出：");
        lastOrderPrintByRecursion(root);

        Stack<TreeNode> stack4PreviousPrint = new Stack<>();
        System.out.println("非递归先序输出：");
        previousOrderPrint(root, stack4PreviousPrint);
    }


    /**
     * 递归方式，先序输出二叉树
     * @param root 根
     */
    public static void previousOrderPrintByRecursion(TreeNode root) {
        if(null == root) {
            System.out.println("The tree is empty! ");
        }
        // 输出根
        System.out.println(root.getData());
        // 输出左子树
        if (null != root.getLeftChild()) {
            previousOrderPrintByRecursion(root.getLeftChild());
        }
        // 输出右子树
        if (null != root.getRightChild()) {
            previousOrderPrintByRecursion(root.getRightChild());
        }
    }

    /**
     * 递归方式，中序输出二叉树
     * @param root 根
     */
    public static void middleOrderPrintByRecursion(TreeNode root) {
        if (null == root) {
            System.out.println("The tree is empty! ");
        }
        // 输出左子树
        if (null != root.getLeftChild()) {
            middleOrderPrintByRecursion(root.getLeftChild());
        }
        // 输出根
        System.out.println(root.getData());
        // 输出右子树
        if (null != root.getRightChild()) {
            middleOrderPrintByRecursion(root.getRightChild());
        }
    }

    /**
     * 递归方式，后序输出二叉树
     * @param root 根
     */
    public static void lastOrderPrintByRecursion(TreeNode root) {
        if (null == root) {
            System.out.println("The tree is empty! ");
        }
        // 输出左子树
        if (null != root.getLeftChild()) {
            lastOrderPrintByRecursion(root.getLeftChild());
        }
        // 输出右子树
        if (null != root.getRightChild()) {
            lastOrderPrintByRecursion(root.getRightChild());
        }
        // 输出根
        System.out.println(root.getData());
    }

    /**
     * 非递归方式，先序输出树
     */
    public static void previousOrderPrint(TreeNode root, Stack<TreeNode> stack) {
        if (null == root) {
            System.out.println("The tree is empty! ");
        }

        TreeNode current = root;
        while (null != current || stack.size() > 0) {
            // 遍历左子树，输出根节点，并入栈
            while (null != current) {
                System.out.println(current.getData());
                stack.push(current);
                current = current.getLeftChild();
            }
            // 寻找右子树不为空的节点，并出栈
            while (stack.size() > 0 && null == current) {
                current = stack.pop();
                current = current.getRightChild();
            }
        }
    }
}

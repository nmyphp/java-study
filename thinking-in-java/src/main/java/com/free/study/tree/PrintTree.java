package com.free.study.tree;

import java.util.HashSet;
import java.util.Set;
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
        System.out.println("\n中序输出：");
        middleOrderPrintByRecursion(root);
        System.out.println("\n后续输出：");
        lastOrderPrintByRecursion(root);

        Stack<TreeNode> stack = new Stack<>();
        System.out.println("\n非递归先序输出：");
        previousOrderPrint(root, stack);
        System.out.println("\n非递归中序输出：");
        middleOrderPrint(root, stack);
        System.out.println("\n非递归后序输出：");
        lastOrderPrint(root, stack);
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
        System.out.print(root.getData());
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
        System.out.print(root.getData());
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
        System.out.print(root.getData());
    }

    /**
     * 非递归方式，先序输出树
     * @param root 根
     * @param stack 栈
     */
    public static void previousOrderPrint(TreeNode root, Stack<TreeNode> stack) {
        if (null == root) {
            System.out.println("The tree is empty! ");
        }
        TreeNode current = root;
        while (null != current || stack.size() > 0) {
            // 遍历左子树，输出根节点，并入栈
            while (null != current) {
                System.out.print(current.getData());
                stack.push(current);
                current = current.getLeftChild();
            }
            // 弹出栈顶节点，遍历其右子树
            current = stack.pop();
            current = current.getRightChild();
        }
    }

    /**
     * 非递归方式，中序输出树
     * @param root 根
     * @param stack 栈
     */
    public static void middleOrderPrint(TreeNode root, Stack<TreeNode> stack) {
        if (null == root) {
            System.out.println("The tree is empty! ");
        }
        TreeNode current = root;
        while (null != current || stack.size() > 0) {
            // 遍历左子树
            while (null != current) {
                stack.push(current);
                current = current.getLeftChild();
            }
            // 出栈并输出栈顶节点
            current = stack.pop();
            System.out.print(current.getData());
            // 遍历右子树
            current = current.getRightChild();
        }
    }

    /**
     * 非递归方式，后序输出树
     * @param root 根
     * @param stack 栈
     */
    public static void lastOrderPrint(TreeNode root, Stack<TreeNode> stack) {
        if (null == root) {
            System.out.println("The tree is empty! ");
        }
        Set<Character> stacked = new HashSet<>();
        TreeNode current = root;
        while (null != current || stack.size() > 0) {
            // 遍历左子树
            while (null != current) {
                stack.push(current);
                // 标记入过栈的节点
                stacked.add(current.getData());
                current = current.getLeftChild();
            }
            current = stack.peek();
            // 如果右子树没有入过栈，则遍历右子树；否则输出栈顶节点
            TreeNode right = current.getRightChild();
            if (null != right && !stacked.contains(right.getData())) {
                current = right;
            } else {
                System.out.print(current.getData());
                stack.pop();
                current = null;
            }
        }
    }
}

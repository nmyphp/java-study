package com.free.study.tree;


import lombok.Getter;
import lombok.Setter;
/**
 * @description: 二叉树节点
 * @author: chenlongjs
 * @date: 2018/1/5
 */

@Setter
@Getter
public class TreeNode {
    private Character data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(Character data) {
        this.data = data;
    }
}

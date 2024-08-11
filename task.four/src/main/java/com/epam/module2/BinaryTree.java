package com.epam.module2;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class BinaryTree implements Tree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    @Override
    public void insert(int value) {
        root = insertRec(root, value);
    }

    @Override
    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.getLeft());
            log.info("{} ", node.getValue());
            inorder(node.getRight());
        }
    }

    @Override
    public void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            log.info("{} ", node.getValue());
        }
    }

    @Override
    public void preorder(TreeNode node) {
        if (node != null) {
            log.info("{} ", node.getValue());
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.getValue()) {
            root.setLeft(insertRec(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(insertRec(root.getRight(), value));
        }

        return root;
    }
}


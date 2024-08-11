package com.epam.module2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeExample {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Traversing the tree
        log.info("In-order traversal:");
        tree.inorder(tree.root);

        log.info("Pre-order traversal:");
        tree.preorder(tree.root);

        log.info("Post-order traversal:");
        tree.postorder(tree.root);
    }
}
package com.epam.module2;


public interface Tree {

    /**
     * Inserts a value into the tree.
     *
     * @param value the value to be inserted
     */
    void insert(int value);

    /**
     * Performs an inorder traversal of the tree starting from the given node.
     *
     * @param node the starting node for the traversal
     */
    void inorder(TreeNode node);

    /**
     * Performs a postorder traversal of the tree starting from the given node.
     *
     * @param node the starting node for the traversal
     */
    void postorder(TreeNode node);

    /**
     * Performs a preorder traversal of the tree starting from the given node.
     *
     * @param node the starting node for the traversal
     */
    void preorder(TreeNode node);

    /**
     * Gets the root node of the tree.
     *
     * @return the root node of the tree
     */
    TreeNode getRoot();
}

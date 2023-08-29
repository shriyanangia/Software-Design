// Fig. 21.17: Tree.java
// TreeNode and Tree class declarations for a binary search tree.
package com.deitel.datastructures;

/**
 * TreeNode class contains 1 public method
 */

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
    // package access members
    TreeNode<T> leftNode;
    T data; // node value
    TreeNode<T> rightNode;

    // constructor initializes data and makes this a leaf node
    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }

    /**
     * This method locates insertion point and inserts new node; ignoring duplicate values
     * @param insertValue
     * no return value
     */
    public void insert(T insertValue) {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else // continue traversing left subtree recursively
                leftNode.insert(insertValue);
        }
        // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {
            // insert new TreeNode
            if (rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else // continue traversing right subtree recursively
                rightNode.insert(insertValue);
        }
    }
} // end class TreeNode

/**
 * Tree class contains 5 public methods and 4 private methods
 * @author code obtained from textbook, edited by snangia
 */

// class Tree definition
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    // constructor initializes an empty Tree of integers
    public Tree() {
        root = null;
    }

    /**
     * This method inserts a new node in the binary search tree
     * @param insertValue
     * no return value
     */
    public void insertNode(T insertValue) {
        if (root == null)
            root = new TreeNode<T>(insertValue); // create root node
        else
            root.insert(insertValue); // call the insert method
    }

    /**
     * This method begins preorder traversal
     * no input parameters
     * no return value
     */
    public void preorderTraversal() {
        preorderHelper(root);
    }

    /**
     * This method is a recursive method to perform preorder traversal
     * @param node
     * no return value
     */
    private void preorderHelper(TreeNode<T> node) {
        if (node == null)
            return;

        System.out.printf("%s ", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree
    }

    /**
     * This method begins inorder traversal
     * no input parameters
     * no return value
     */
    public void inorderTraversal() {
        inorderHelper(root);
    }

    /**
     * This method is a recursive method to perform inorder traversal
     * If input characters are not among A-Z or 0-9 the method will return false
     * @param node
     * no return value
     */
    private void inorderHelper(TreeNode<T> node) {
        if (node == null)
            return;

        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree
    }

    /**
     * This method begins postorder traversal
     * no input parameters
     * no return value
     */
    public void postorderTraversal() {
        postorderHelper(root);
    }

    /**
     * This method is a recursive method to perform postorder traversal
     * @param node
     * no return value
     */
    private void postorderHelper(TreeNode<T> node) {
        if (node == null)
            return;

        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    /**
     * This method begins outputting the tree
     * @no input parameters
     * no return value
     */
    public void outputTreeTraversal() { outputTree(root,0); }

    /**
     * This method is a recursive method to print out the tree
     * @param root
     * @param totalSpaces totalSpaces represents the number of spaces preceding the value to be output
     * no return value
     */
    private void outputTree(TreeNode root, int totalSpaces)
    {
        if(root==null)
            return;

       outputTree(root.rightNode, totalSpaces+5);

        System.out.printf("%s ", "\n");
        for(int i=1; i<totalSpaces; i++)
        {
            System.out.print(" ");
        }
        System.out.print(root.data);

        outputTree(root.leftNode, totalSpaces+5);
    }
} // end class Tree

/**************************************************************************
 * Code taken from textbook example in Chapter 21 and then edited to
 * answer the course question
 *************************************************************************/


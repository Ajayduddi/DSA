package com.datastructures.trees;

/**
 * Interface representing tree traversal operations.
 */
public interface Traversal {

	/**
	 * Performs a preorder traversal of the tree starting from the given node.
	 * In preorder traversal, the node is processed before its child nodes.
	 *
	 * @param node the starting node for the traversal
	 */
	void preorder(Node node);

	/**
	 * Performs an inorder traversal of the tree starting from the given node.
	 * In inorder traversal, the node is processed between its child nodes.
	 *
	 * @param node the starting node for the traversal
	 */
	void inorder(Node node);

	/**
	 * Performs a postorder traversal of the tree starting from the given node.
	 * In postorder traversal, the node is processed after its child nodes.
	 *
	 * @param node the starting node for the traversal
	 */
	void postorder(Node node);

	
	/**
	 * Performs a Level order traversal on the given tree starting from the specified node.
	 *
	 * @param node the starting node for the BFS traversal
	 */
	void LevelOrder(Node node);

}
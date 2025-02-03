/**
 * This class provides methods for tree traversal.
 * 
 * Tree traversal is a process of visiting all the nodes in a tree data structure.
 * There are three common types of tree traversal:
 * 
 * 1. Preorder Traversal:
 *    - Definition: Visit the root node, then recursively visit the left subtree, and finally the right subtree.
 *    - Example: For a tree with root A, left child B, and right child C, the preorder traversal is A, B, C.
 *    - Visualization:
 *          A
 *         / \
 *        B   C
 *      Preorder: A -> B -> C
 *    - Applications: Used to create a copy of the tree, prefix expression evaluation in expression trees.
 *    - Use Cases: Syntax tree traversal in compilers, directory structure traversal.
 * 
 * 2. Inorder Traversal:
 *    - Definition: Recursively visit the left subtree, visit the root node, and finally the right subtree.
 *    - Example: For a tree with root A, left child B, and right child C, the inorder traversal is B, A, C.
 *    - Visualization:
 *          A
 *         / \
 *        B   C
 *      Inorder: B -> A -> C
 *    - Applications: Used to get nodes of a binary search tree in ascending order.
 *    - Use Cases: Binary search trees, expression trees.
 * 
 * 3. Postorder Traversal:
 *    - Definition: Recursively visit the left subtree, then the right subtree, and finally the root node.
 *    - Example: For a tree with root A, left child B, and right child C, the postorder traversal is B, C, A.
 *    - Visualization:
 *          A
 *         / \
 *        B   C
 *      Postorder: B -> C -> A
 *    - Applications: Used to delete the node from the tree, postfix expression evaluation in expression trees.
 *    - Use Cases: Memory management, expression tree evaluation.
 */

package com.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal_Implementation extends Node implements Traversal {
	
	private Queue<Node> queue;

	public Traversal_Implementation() {
		this.queue = new LinkedList<>();
	}	

	@Override
	public void preorder(Node node) {
		// base condition
		if (node == null) {
			return;
		}

		System.out.print(node.val + " -> "); // print the root node	
		preorder(node.left); // call the left subtree
		preorder(node.right); // call the right subtree
	}

	@Override
	public void inorder(Node node) {
		// base condition
		if (node == null) {
			return;
		}

		inorder(node.left); // call the left subtree
		System.out.print(node.val + " -> "); // print the root node
		inorder(node.right); // call the right subtree
	}

	
	@Override
	public void postorder(Node node) {
		// base condition
		if (node == null) {
			return;
		}

		postorder(node.left); // call the left subtree
		postorder(node.right); // call the right subtree
		System.out.print(node.val + " -> "); // print the root node
	}

	@Override
	public void LevelOrder(Node node) {
		// base condition
		if (node == null) {
			return;
		}

		if (node.left != null) {
			queue.add(node.left);
		}
		
		if (node.right != null) {
			queue.add(node.right);
		}
		
		System.out.print(node.val + " -> ");
		while (!queue.isEmpty()) {
			node = queue.remove();
			if (node.left != null) {
				queue.add(node.left);
			}
			
			if (node.right != null) {
				queue.add(node.right);
			}
			System.out.print(node.val + " -> ");
		}
		System.out.println();
	}
}

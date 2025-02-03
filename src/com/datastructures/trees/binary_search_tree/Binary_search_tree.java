/*
 * A Binary Search Tree (BST) is a node-based binary tree data structure with the following properties:
 * 
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 * 
 * A BST does not necessarily have to be balanced. However, if it is balanced, operations such as insertion, deletion, 
 * and traversal can be more efficient.
 * 
 * Time Complexity:
 * - Insertion: O(h), where h is the height of the tree.
 * - Deletion: O(h), where h is the height of the tree.
 * - Traversal: O(n), where n is the number of nodes in the tree.
 * - Retrieval: O(h), where h is the height of the tree.
 * 
 * In the worst case, the height of the tree can be O(n) for a skewed tree, making the operations O(n). 
 * In a balanced BST, the height is O(log n), making the operations O(log n).
 * 
 * 
 * Usage of Binary Search Trees:
 * 
 * - Searching: BSTs provide efficient searching capabilities, making them useful in applications where search operations are frequent.
 * - Sorting: BSTs can be used to maintain a sorted list of elements, allowing for efficient insertion and deletion while keeping the list sorted.
 * - Dynamic Sets: BSTs are useful for implementing dynamic sets where elements can be added or removed dynamically while maintaining order.
 * - Database Indexing: BSTs are used in database indexing to allow for efficient querying and retrieval of records.
 * - Priority Queues: BSTs can be used to implement priority queues where elements are processed based on their priority.
 * - Symbol Tables: BSTs are used in compilers and interpreters to implement symbol tables for efficient variable and function lookups.
 * - Network Routing: BSTs can be used in network routing algorithms to efficiently manage and route data packets.
 * - File Systems: BSTs are used in file systems to manage and organize files and directories efficiently.
 */

package com.datastructures.trees.binary_search_tree;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.Traversal_Implementation;

public class Binary_search_tree extends Node{

	private Node root;
	private int size;
	private final Traversal traversal;

	public Binary_search_tree() {
		this.traversal = new Traversal_Implementation();
		this.size = 0;
	}

	// Insert elements
	public void insert(int value) {
		root = populate(root, value);
	}

	// helper function to insert element to the binary search tree
	public Node populate(Node node, int val) {

		// base condition
		if (node == null) {
			node = new Node(val);
			size++;
			return node;
		}

		if (val >= node.val) {
			node.right = populate(node.right, val);
		}
		else {
			node.left = populate(node.left, val);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return node;
	}

	// display the binary tree
	public void display() {
		display(this.root, 0);
	}

	// helper function to display internal nodes 
	private void display(Node node, int level) {
		if (node == null) {
			return;
		}

		display(node.right, level + 1);

		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("\t");
			}
			System.out.println("|-------" + node.val);
		}
		else {
			System.out.println(node.val);
		}

		display(node.left, level + 1);
	}
	
	// function to check present BST is balanced tree or not
	public boolean isBalanced() {
		return isBalanced_helper(root);
	}

	public boolean isBalanced_helper(Node node) {
		if (node == null) {
			return true;
		}

		return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced_helper(node.left)
				&& isBalanced_helper(node.right);
	}

	// get height
	public int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	// get size
	public int size() {
		return size;
	}

	public void postorder() {
		this.traversal.postorder(root);
	}

	public void inorder() {
		this.traversal.inorder(root);
	}

	public void preorder() {
		this.traversal.preorder(root);
	}

	public void LevelOrder() {
		this.traversal.LevelOrder(root);
	}
}

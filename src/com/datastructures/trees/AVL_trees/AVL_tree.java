/*
 * AVL Tree:
 * 
 * An AVL tree is a self-balancing binary search tree where the difference between heights of left and right subtrees 
 * cannot be more than one for all nodes. If at any time during insertion or deletion, the height difference becomes 
 * more than one, the tree is rebalanced using rotations.
 * 
 * Definition:
 * - An AVL tree is a height-balanced binary search tree.
 * - The height difference (balance factor) between the left and right subtrees of any node is at most one.
 * 
 * Rules:
 * - The balance factor of a node is calculated as the height of the left subtree minus the height of the right subtree.
 * - If the balance factor of any node becomes less than -1 or greater than 1, the tree is rebalanced.
 * - Rebalancing is done using rotations: left rotation, right rotation, left-right rotation, and right-left rotation.
 * 
 * What makes a tree not an AVL tree:
 * - If the balance factor of any node in the tree is less than -1 or greater than 1, the tree is not an AVL tree.
 * 
 * Time Complexity:
 * - Insertion: O(log n)
 * - Deletion: O(log n)
 * - Finding/Search: O(log n)
 * 
 * When to use AVL Trees:
 * - When you need to maintain a sorted dataset with frequent insertions and deletions.
 * - When you need to ensure that the tree remains balanced to guarantee O(log n) time complexity for search, insert, and delete operations.
 * - In applications where the data is constantly changing and you need to maintain order, such as in databases and file systems.
 * - When you need to perform many read and write operations and require consistent performance.
 */

/*
 * Types of Rotations for Rebalancing AVL Tree:
 * 
 * 1. Left Rotation (LL Rotation):
 *    Example:
 *        z                                      y 
 *       / \                                   /   \
 *      T1   y      Left Rotate (z)          z      x
 *          /  \   - - - - - - - - ->      /  \    /  \
 *         T2   x                         T1   T2 T3   T4
 *             /  \
 *           T3   T4
 * 
 * 2. Right Rotation (RR Rotation):
 *    Example:
 *           z                                      y 
 *          / \                                   /   \
 *         y   T4   Right Rotate (z)            x      z
 *        /  \    - - - - - - - - ->          /  \    /  \
 *       x   T3                             T1   T2 T3   T4
 *      /  \
 *    T1   T2
 * 
 * 3. Left-Right Rotation (LR Rotation):
 *    Example:
 *        z                               z                           x
 *       / \                            /   \                        /  \ 
 *      y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
 *     /  \      - - - - - - - - ->   /  \      - - - - - - - ->  /  \   /  \
 *   T1   x                          y    T3                    T1   T2 T3   T4
 *       /  \                       /  \
 *     T2   T3                    T1   T2
 * 
 * 4. Right-Left Rotation (RL Rotation):
 *    Example:
 *      z                            z                            x
 *     /  \                         /  \                         /  \ 
 *   T1   y   Right Rotate (y)    T1    x    Left Rotate(z)    z      y
 *       /  \  - - - - - - - ->       /  \   - - - - - - - ->  /  \   /  \
 *     x   T4                       T2    y                  T1   T2 T3   T4
 *    /  \                               /  \
 *  T2   T3                            T3   T4
 */

package com.datastructures.trees.AVL_trees;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.Traversal_Implementation;

public class AVL_tree extends Node {
	
	private Node root;
	private int size;
	private final Traversal traversal;

	public AVL_tree() {
		this.size = 0;
		this.traversal = new Traversal_Implementation();
	}

	// insert elements
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

		return rotate(node);
	}

	// Rebalancing the tree using rotations
	public Node rotate(Node node) {

		// left heavy
		if (height(node.left) - height(node.right) > 1) {
			// left - left heavy
			if (height(node.left.left) - height(node.left.right) > 0) {
				return rightRotate(node);
			}

			// left - right heavy
			if (height(node.left.left) - height(node.left.right) < 0) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}

		// right heavy
		if (height(node.left) - height(node.right) < -1) {
			// right - right heavy
			if (height(node.right.left) - height(node.right.right) < 0) {
				return leftRotate(node);
			}

			// right - left heavy
			if (height(node.right.left) - height(node.right.right) > 0) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}

		// Update heights
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}
	
	
	public Node leftRotate(Node p) {
		Node c = p.right;
		Node t2 = p.right.left;

		c.left = p;
		p.right = t2;

		// Update heights
		p.height = Math.max(height(p.left), height(p.right)) + 1;
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		return c;
	}
	
	public Node rightRotate(Node p){
		Node c = p.left;
		Node t3 = p.left.right;

		c.right = p;
		p.left = t3;

		// Update heights
		p.height = Math.max(height(p.left), height(p.right)) + 1;
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		return c;
	}
	
	// display the binary tree
	public void display() {
		display(root, 0);
	}
	
	// helper function to display internal nodes 
	public void display(Node node, int level) {

		// base condition
		if (node == null) {
			return;
		}

		display(node.right, level + 1);

		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("\t");
			}
			System.out.println("|-----" + node.val);
		}
		else {
			System.out.println(node.val);
		}

		display(node.left, level + 1);
	}
	
	// check the tree is balanced or not
	public boolean isBalanced() {
		return isBalanced_helper(root);
	}

	public boolean isBalanced_helper(Node node) {
		// base condition
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

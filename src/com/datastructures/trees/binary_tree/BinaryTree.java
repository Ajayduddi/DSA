/**
 * A binary tree does not impose rules such as "left-side values must be smaller
 * than the root, and right-side values must be larger." These value-based rules
 * apply only to Binary Search Trees (BSTs).
 * 
 * A general binary tree does not require all nodes to be at the same level or
 * for levels to be completely filled.
 * 
 * The definition of a binary tree is based purely on its structure: each node
 * can have at most two children. It does not enforce rules on the number of
 * nodes, their levels, or how values are arranged.
 * 
 * We can implement Binary trees using linked list (or) arrays.
 * 
 * Here h = height, n = size of the binary tree.
 * Insertion: O(h) (worst case O(n))
 * Deletion: O(h) (worst case O(n))
 * Find: O(h) (worst case O(n))
 * 
 * 
 * Real-life applications of binary trees:
 * 
 * 1. Expression Trees: Used in compilers to represent expressions.
 * 2. Huffman Coding Trees: Used in data compression algorithms.
 * 3. Binary Heaps: Used in priority queues.
 * 4. Decision Trees: Used in machine learning for decision-making processes.
 * 5. Routing Tables: Used in network routers.
 * 6. File System Hierarchies: Used to represent directories and files.
 * 7. Syntax Trees: Used in compilers to represent the structure of program code.
 * 8. Databases: Used in indexing to improve search operations.
 * 
 */

/*
 * Properties of a Binary Tree:
 * 
 * 1. Node: A fundamental part of a binary tree that contains data and links to its children.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *    Here, 1, 2, and 3 are nodes.
 * 
 * 2. Edge: A link between two nodes.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *    The connections (1-2) and (1-3) are edges.
 * 
 * 3. Root: The topmost node of a binary tree.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *    Here, 1 is the root.
 * 
 * 4. Level: The number of edges on the path from the root to the node.
 *    Example: 
 *        1 (Level 0)
 *       / \
 *      2   3 (Level 1)
 *    The root node is at level 0, and its children are at level 1.
 * 
 * 5. Height: The number of edges on the longest path from the root to a leaf.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *         /
 *        4
 *    The height of this tree is 2 (path 1-3-4).
 * 
 * 6. Sibling: Nodes that share the same parent.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *    Here, 2 and 3 are siblings.
 * 
 * 7. Parent: A node that has a link to one or more child nodes.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *    Here, 1 is the parent of 2 and 3.
 * 
 * 8. Child: A node that has a parent node.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *    Here, 2 and 3 are children of 1.
 * 
 * 9. Degree: The number of children a node has.
 *    Example: 
 *        1
 *       / \
 *      2   3
 *    The degree of node 1 is 2.
 * 
 * 10. Size: The total number of nodes in the binary tree.
 *     Example: 
 *        1
 *       / \
 *      2   3
 *    The size of this tree is 3.
 * 
 * 11. Leaf: A node that does not have any children.
 *     Example: 
 *        1
 *       / \
 *      2   3
 *         /
 *        4
 *    Here, nodes 2 and 4 are leaves.
 * 
 * 12. Internal Node: A node that has at least one child.
 *     Example: 
 *        1
 *       / \
 *      2   3
 *         /
 *        4
 *    Here, nodes 1 and 3 are internal nodes.
 * 
 * 13. Ancestor: A node that is located on the path from the root to a given node.
 *     Example: 
 *        1
 *       / \
 *      2   3
 *         /
 *        4
 *    Here, 1 and 3 are ancestors of node 4.
 * 
 * 14. Descendant: A node that is located on the path from a given node to any leaf.
 *     Example: 
 *        1
 *       / \
 *      2   3
 *         /
 *        4
 *    Here, 3 and 4 are descendants of node 1.
 * 
 */

package com.datastructures.trees.binary_tree;

import java.util.Scanner;
import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.Traversal_Implementation;

public class BinaryTree extends Node{
 
	private Node root;
	private int size;
	private final Traversal traversal;

	public BinaryTree() {
		this.traversal = new Traversal_Implementation();
		this.size = 0;
	}
	
	// insert elements
	public void insert(Scanner in)  {
		System.out.println("Enter the root node: ");
		int value = in.nextInt();
		this.root = new Node(value);
		size++;
		populate(in, root);
	}
	
	// insert elements after the root node
	public void populate(Scanner in, Node node) {

		System.out.println("Do you want to insert element to the Left of " + node.val);
		boolean left = in.nextBoolean();
		if (left) {
			System.out.println("Enter the value want to insert to the Left of " + node.val);
			int value = in.nextInt();
			node.left = new Node(value);
			size++;
			populate(in, node.left);
		}

		System.out.println("Do you want to insert element to the Right of " + node.val);
		boolean right = in.nextBoolean();
		if (right) {
			System.out.println("Enter the value want to insert to the Right of " + node.val);
			int value = in.nextInt();
			node.right = new Node(value);
			size++;
			populate(in, node.right);
		}

	}
	
	// get the size of the binary tree
	public int size() {
		return size;
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

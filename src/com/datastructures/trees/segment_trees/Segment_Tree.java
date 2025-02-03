/**
 * A Segment Tree is a data structure that allows answering range queries and updating elements in logarithmic time.
 * It is a binary tree used for storing intervals or segments. It allows querying which of the stored segments contain a given point.
 * 
 * Properties of Segment Tree:
 * - Each node in the Segment Tree represents an interval or segment of the array.
 * - The root of the Segment Tree represents the whole array.
 * - Each leaf node represents a single element of the array.
 * - Each internal node represents the union of its children.
 * - Balanced Tree: The height of the tree is `O(log n)` where `n` is the number of elements in the array.
 * 
 * Operations and Time Complexity:
 * - Build: O(n) Constructing the segment tree from an array.
 * - Query (Range Sum, Range Minimum, etc.): O(log n)
 * - Update: O(log n) Updating an element in the array and modifying the segment tree accordingly.
 * 
 * When to use Segment Trees:
 * - When you need to perform multiple range queries (e.g., sum, minimum, maximum) and updates on an array efficiently.
 * - When you need to answer queries like range sum, range minimum, range maximum, etc.
 * 
 * Example:
 * Consider an array: [1, 3, 5, 7, 9, 11]
 * The Segment Tree for range sum queries would look like this:
 * 
 *                  [36]
 *                /      \
 *            [9]         [27]
 *           /  \        /    \
 *        [4]   [5]   [16]   [11]
 *       /  \         /  \      \
 *     [1]  [3]     [7]  [9]   [11]
 * 
 * Visualization:
 * - The root node represents the sum of the entire array (36).
 * - The left child of the root represents the sum of the first half of the array (9).
 * - The right child of the root represents the sum of the second half of the array (27).
 * - This structure allows efficient range sum queries and updates.
 */

package com.datastructures.trees.segment_trees;

public class Segment_Tree {

	private int size;
	private Node root;
	private String queryType;

	public Segment_Tree() {
		this.size = 0;
	}

	// Build segment tree
	public void build(int[] arr, String quertType) {
		this.queryType = quertType;
		this.root = build(arr, 0, arr.length - 1);
	}
	
	// helper function to build the entier segment tree
	public Node build(int[] arr, int start, int end) {
		// base condition
		if (start == end) {
			Node node = new Node();
			node.range = new int[] { start, end };
			node.val = arr[start];
			size++;
			return node;
		}

		int mid = start + (end - start) / 2;
		Node node = new Node();
		node.range = new int[] { start, end };
		node.left = build(arr, start, mid);
		node.right = build(arr, mid + 1, end);

		if (queryType == "sum") {
			node.val = node.left.val + node.right.val;
		}
		else if (queryType == "prod") {
			node.val = node.left.val * node.right.val;
		}
		else if (queryType == "min") {
			node.val = Integer.min(node.left.val, node.right.val);
		}
		else {
			node.val = Integer.max(node.left.val, node.right.val);
		}

		size++;
		return node;
	}

	// display the segment tree
	public void display() {
		display(root, 0);
	}
	
	// helper function to display the segment tree
	public void display(Node node, int level) {
		// base condition
		if (node == null) {
			return;
		}

		display(node.right, level + 1);

		if (level > 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("\t");
			}
			System.out.println("|------- " + node.val);
		}
		else {
			System.out.println(node.val);
		}

		display(node.left, level + 1);
	}
	
	// perform the query on array with in the given range
	public int query(int start, int end) {

		if (queryType == "sum") {
			return sum(root, start, end);
		}
		else if (queryType == "prod") {
			return prod(root, start, end);
		}
		else if (queryType == "min") {
			return min(root, start, end);
		}
		else {
			return max(root, start, end);
		}
	}

	// helper function to find Sum of the array with in the given range
	public int sum(Node node, int start, int end) {

		// base condition
		if (node == null) {
			return 0;
		}

		// case 1 : node range overlap with in the query range ( fully overlap )
		if (node.range[0] >= start && node.range[1] <= end) {
			return node.val;
		}
		// case 2 : query range before the node range &  query range after the node range
		else if (end < node.range[0] || start > node.range[1]) {
			return 0;
		}
		// case 3 : any one of the node range overlap with the query range ( partially overlap )
		else {
			return sum(node.left, start, end) + sum(node.right, start, end);
		}
	}
	
	// helper function to find prod of the array with in the given range
	public int prod(Node node, int start, int end) {
		
		// base condition
		if (node == null) {
			return 1;
		}

		// case 1 : node range overlap with in the query range ( fully overlap )
		if (node.range[0] >= start && node.range[1] <= end) {
			return node.val;
		}
		// case 2 : query range before the node range || query range after the node range
		else if (node.range[0] > end || node.range[1] < start) {
			return 1;
		}
		// case 3 : any one of the node range overlap with the query range ( partially overlap )
		else {
			return prod(node.left, start, end) * prod(node.right, start, end);
		}
	}
	
	// helper function to find min of the array with in the given range
	public int min(Node node, int start, int end) {

		// base condition
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		// case 1 : node range overlap with in the query range ( fully overlap )
		if (node.range[0] >= start && node.range[1] <= end) {
			return node.val;
		}
		// case 2 : query range before the node range || query range after the node range
		else if (node.range[0] > end || node.range[1] < start) {
			return Integer.MAX_VALUE;
		}
		// case 3 : any one of the node range overlap with the query range ( partially overlap )
		else {
			return Integer.min( min(node.left, start, end), min(node.right, start, end));
		}
	}
	
	// helper function to find max of the array with in the given range
	public int max(Node node, int start, int end) {

		// base condition
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		// case 1 : node range overlap with in the query range ( fully overlap )
		if (node.range[0] >= start && node.range[1] <= end) {
			return node.val;
		}
		// case 2 : query range before the node range || query range after the node range
		else if (node.range[0] > end || node.range[1] < start) {
			return Integer.MIN_VALUE;
		}
		// case 3 : any one of the node range overlap with the query range ( partially overlap )
		else {
			return Integer.max( max(node.left, start, end) , max(node.right, start, end));
		}
	}

	// get size of the segment tree
	public int size() {
		return size;
	}

	private class Node{	
		private int val;
		private int[] range;
		private Node left;
		private Node right;
		
		public Node() {}
		
	}
}

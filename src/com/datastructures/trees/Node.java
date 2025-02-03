/**
 * This class represents a node in a Binary Tree.
 * Each node contains an integer value, references to the left and right child nodes,
 * and the height of the node for balancing purposes.
 */

package com.datastructures.trees;

public class Node {

		public int val;
		public Node left;
		public Node right;
		public int height;

		public Node() {}
		
		public Node(int val) {
			this.val = val;
		}
}

package com.datastructures.trees.AVL_trees;

public class Main {
	public static void main(String[] args) {
		AVL_tree balancedTree = new AVL_tree();

		balancedTree.insert(22);
		balancedTree.insert(34);
		balancedTree.insert(15);
		balancedTree.insert(15);
		balancedTree.insert(5);
		balancedTree.insert(4);
		balancedTree.insert(37);
		balancedTree.insert(16);
		balancedTree.insert(38);
		balancedTree.insert(19);
		balancedTree.display();

		System.out.println("\nCurrent size of the balancedTree : " + balancedTree.size());
		System.out.println("Current Tree is balanced: " + balancedTree.isBalanced());
		System.out.println("\npreorder : ");
		balancedTree.preorder();
		System.out.println("\nInorder : ");
		balancedTree.inorder();
		System.out.println("\npostorder : ");
		balancedTree.postorder();
		System.out.println("\nLevelOrder : ");
		balancedTree.LevelOrder();
	}
}

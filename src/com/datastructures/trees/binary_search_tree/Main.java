package com.datastructures.trees.binary_search_tree;

public class Main {
	public static void main(String[] args) {
		Binary_search_tree bst = new Binary_search_tree();

		bst.insert(22);
		bst.insert(34);
		bst.insert(15);
		bst.insert(5);
		bst.insert(29);
		bst.insert(37);
		bst.insert(16);
		bst.display();

		System.out.println("\nCurrent size of the BST : " + bst.size());
		System.out.println("Current BST is balanced: " + bst.isBalanced());
		System.out.println("\npreorder : ");
		bst.preorder();
		System.out.println("\nInorder : ");
		bst.inorder();
		System.out.println("\npostorder : ");
		bst.postorder();
		System.out.println("\nLevelorder : ");
		bst.LevelOrder();
	}
}

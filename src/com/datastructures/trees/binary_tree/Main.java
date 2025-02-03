package com.datastructures.trees.binary_tree;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Scanner in = new Scanner(System.in);

		tree.insert(in);
		System.out.println("\nCurrent size of the binary tree : "+ tree.size() + "\n");
		tree.display();
		System.out.println("\npreorder : ");
		tree.preorder();
		System.out.println("\nInorder : ");
		tree.inorder();
		System.out.println("\npostorder : ");
		tree.postorder();
		System.out.println("\nLevelOrder : ");
		tree.LevelOrder();
	}
}

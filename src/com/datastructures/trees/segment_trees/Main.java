package com.datastructures.trees.segment_trees;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Segment_Tree tree = new Segment_Tree();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the size of the array : ");
		int size = in.nextInt();
		System.out.print("Enter array elements seperate by space : ");
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}

		System.out.println("1 to preform sum operation\n2 to perform product operation\n3 to find min value\n4 to find max value\nEnter your option : ");
		switch (in.nextInt()) {
			case 1:
				tree.build(arr,"sum");
				break;

			case 2:
				tree.build(arr, "prod");
				break;

			case 3:
				tree.build(arr,"min");
				break;

			case 4:
				tree.build(arr, "max");
				break;

			default:
				break;
		}

		tree.display();

		System.out.println("\nCurrent size of the segment tree : " + tree.size());
		System.out.println("query preform on array element from index 1 to 5 : " + tree.query(1, 5));
		in.close();
	}
}

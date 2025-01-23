package com.datastructures.linkedlist;

public class Main {

	public static void main(String[] args) {

		//single linked list
		LL list = new LL();
		list.insertFirst(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.relpace(0, 22);
		list.add(6);
		list.insertFirst(5);
		list.insert(5, 18); // inset the element at the index 5
		list.insertUsingRecursion(6, 45); // insert the element at the index 6
		list.display(); // display the Linkedlist
		System.out.println("Size of the list : " + list.size()); // displat the size of the Linkedlist
		
		list.remove();
		list.display();
		list.removeFirst();
		list.display();
		list.remove(1); // remove the element at index 0
		list.display();
		list.remove(5); // here we get the error , because the index is out of bounds

		System.out.println("First element : " + list.getFirst());
		System.out.println("Last element : " + list.getLast());
		if (list.find(22) != null) {
			System.out.println("22 Find at : " + list.find(22));
		}
		else {
			System.out.println("22 is not found");
		}
		System.out.println("\n");

		// double Linkedlist
		DoubleLL list2 = new DoubleLL();
		list2.insertFirst(1);
		list2.add(2);
		list2.add(3);
		list2.display();

		list2.insertFirst(22);
		list2.display();

		list2.insert(3, 18);
		list2.display();

		System.out.println("Size : " + list2.size());

		list2.replace(5, 0); // getting error because index is out of bounds

		list2.replace(0, 20);
		list2.display();

		list2.removeFirst();
		list2.display();

		list2.remove();
		list2.display();

		list2.remove(2);
		list2.display();

		if (list2.find(22) != null) {
			System.out.println("22 Find at : " + list2.find(22));
		}
		else {
			System.out.println("22 is not found");
		}
	}
}

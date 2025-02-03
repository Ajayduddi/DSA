/**
 * This class represents a Min Heap data structure.
 * It provides methods to insert and remove elements while maintaining the min-heap property.
 * In a Min-heap, for any given node I, the value of I is less than or equal to the values of its children.
 * 
 * Implementation:
 * - Heaps are commonly implemented using arrays.
 * - For a node at index i (index starting from 0):
 *   - Its left child is at index 2*i + 1.
 *   - Its right child is at index 2*i + 2.
 *   - Its parent is at index (i-1)/2.
 */

package com.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

public class Min_Heap implements Heap {
	
	private List<Integer> array;
	
	/**
	 * Constructor to initialize the Min Heap.
	 */
	public Min_Heap() {
		this.array = new ArrayList<>();
	}

	/**
	 * Inserts elements from the given array into the heap.
	 *
	 * This method iterates over the provided array and inserts each element
	 * into the heap. After all elements are added, it ensures the heap property is
	 * maintained by calling the heapify method.
	 *
	 * @param arr the array of integers to be inserted into the heap
	 *
	 * Time Complexity:
	 * - O(n) to insert the elements into the heap
	 *
	 * Steps:
	 * 1. Iterate over the provided array.
	 * 2. Add each element to the heap's internal array.
	 * 3. Call the heapify method to maintain the min-heap property.
	 */
	@Override
	public final void insert(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			array.add(arr[i]);
		}
		heapify();
	}

	/**
	 * Converts the list into a min-heap.
	 *
	 * This method ensures the heap property is maintained by calling the
	 * heap_check_down method on each non-leaf node starting from the bottom.
	 *
	 * Time Complexity:
	 * - O(n) to build the heap
	 *
	 * Steps:
	 * 1. Calculate the index of the last non-leaf node.
	 * 2. Iterate from the last non-leaf node to the root node.
	 * 3. Call the heap_check_down method on each node to maintain the min-heap property.
	 */
	private void heapify() {
		int startIndex = (array.size() / 2) - 1; // Last non-leaf node index
		for (int i = startIndex; i >= 0; i--) {
			heap_check_down(i);
		}
	}

	/**
	 * Inserts an element into the heap in O(log n) time.
	 * 
	 * @param val the value to be inserted into the heap
	 *
	 * Time Complexity:
	 * - O(log n) to insert the element and maintain the heap property
	 *
	 * Steps:
	 * 1. Add the element to the end of the heap's internal array.
	 * 2. Call the after_insert method to maintain the min-heap property.
	 */
	@Override
	public final void insert(int val) {
		array.add(val);
		int currentIndex = array.size() - 1;
		after_insert(currentIndex);
	}

	/**
	 * Helper function to adjust the min-heap after insertion.
	 * 
	 * @param currentIndex the index of the newly inserted element
	 *
	 * Time Complexity:
	 * - O(log n) to adjust the heap
	 *
	 * Steps:
	 * 1. If the currentIndex is the root node, return.
	 * 2. Calculate the parent index of the current node.
	 * 3. If the value of the parent node is greater than the value of the current node, swap them.
	 * 4. Recursively call after_insert on the parent index.
	 */
	private final void after_insert(int currentIndex) {
		// if currentIndex is a root node
		if (currentIndex == 0) {
			return;
		}

		int parentIndex = (currentIndex - 1) / 2;

		// In min-heap the value of currentIndex is less than or equal to the values of its children.
		if (array.get(parentIndex) > array.get(currentIndex)) {
			swap(currentIndex, parentIndex);
			after_insert(parentIndex);
		}
	}
	
	/**
	 * Removes the minimum element from the heap in O(log n) time.
	 * 
	 * @return the minimum element in the heap
	 *
	 * Time Complexity:
	 * - O(log n) to remove the element and maintain the heap property
	 *
	 * Steps:
	 * 1. If the heap is empty, print a message and return -1.
	 * 2. Get the minimum element (root of the heap).
	 * 3. Swap the root with the last element in the heap.
	 * 4. Remove the last element from the heap.
	 * 5. Call the after_remove method to maintain the min-heap property.
	 * 6. Return the minimum element.
	 */
	@Override
	public final int remove() {
		// if empty
		if (array.isEmpty()) {
			System.out.println("Removing from an empty heap!");
			return -1;
		}
		
		int num = min();
		swap(0, array.size() - 1);
		array.remove(array.size() - 1);
		after_remove(0);
		return num;
	}

	/**
	 * Helper function to adjust the min-heap after removal.
	 * 
	 * @param currentIndex the index of the element to be adjusted
	 *
	 * Time Complexity:
	 * - O(log n) to adjust the heap
	 *
	 * Steps:
	 * 1. Call the heap_check_down method to maintain the min-heap property.
	 */
	private final void after_remove(int currentIndex) {
		heap_check_down(currentIndex);
	}

	/**
	 * Helper function to move down the element to maintain the heap property.
	 * 
	 * @param currentIndex the index of the element to be moved down
	 *
	 * Time Complexity:
	 * - O(log n) to adjust the heap
	 *
	 * Steps:
	 * 1. Calculate the indices of the left and right children of the current node.
	 * 2. Determine the smallest value among the current node and its children.
	 * 3. If the smallest value is not the current node, swap the current node with the smallest child.
	 * 4. Recursively call heap_check_down on the index of the smallest child.
	 */
	private void heap_check_down(int currentIndex) {
		int leftIndex = 2 * currentIndex + 1;
		int rightIndex = 2 * currentIndex + 2;
		int smallest = currentIndex;

		if (rightIndex < array.size() && array.get(rightIndex) < array.get(smallest)) {
			smallest = rightIndex;
		}
		
		if (leftIndex < array.size() && array.get(leftIndex) < array.get(smallest)) {
			smallest = leftIndex;
		}
		
		if (smallest != currentIndex) {
			swap(currentIndex, smallest);
			heap_check_down(smallest);
		}
	}

	/**
	 * Returns the minimum element in the heap in O(1) time.
	 * 
	 * @return the minimum element in the heap
	 *
	 * Time Complexity:
	 * - O(1) to get the minimum element
	 *
	 * Steps:
	 * 1. If the heap is empty, print a message and return -1.
	 * 2. Return the root of the heap (minimum element).
	 */
	public final int min() {
		// if empty
		if (array.isEmpty()) {
			System.out.println("Empty heap!");
			return -1;
		}

		return array.get(0);
	}
	
	/**
	 * Sorts the elements of the heap in ascending order and returns them as a list.
	 * This method removes all elements from the heap.
	 * This operation takes O(n log n) time.
	 *
	 * @return a list of integers sorted in ascending order, or null if the heap is empty.
	 *
	 * Time Complexity:
	 * - O(n log n) to sort the elements
	 *
	 * Steps:
	 * 1. If the heap is empty, print a message and return null.
	 * 2. Create an empty list to store the sorted elements.
	 * 3. While the heap is not empty, remove the minimum element from the heap and add it to the list.
	 * 4. Return the list of sorted elements.
	 */
	@Override
	public final List<Integer> heapSort() {
		if (array.isEmpty()) {
			System.out.println("Heap is empty!!");
			return null;
		}

		List<Integer> ans = new ArrayList<>();
		while (!array.isEmpty()) {
			ans.add(remove());
		}

		return ans;
	}
	
	/**
	 * Swaps two elements in the heap.
	 * 
	 * @param i the index of the first element
	 * @param j the index of the second element
	 *
	 * Time Complexity:
	 * - O(1) to swap two elements
	 *
	 * Steps:
	 * 1. Store the value of the element at index i in a temporary variable.
	 * 2. Set the value of the element at index i to the value of the element at index j.
	 * 3. Set the value of the element at index j to the value stored in the temporary variable.
	 */
	private final void swap(int i, int j) {
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
}

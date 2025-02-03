/*
 * A heap is a special tree-based data structure that satisfies the heap property.
 * There are two types of heaps:
 * 1. Max-Heap: In a max-heap, for any given node I, the value of I is greater than or equal to the values of its children.
 * 2. Min-Heap: In a min-heap, for any given node I, the value of I is less than or equal to the values of its children.
 *
 * Rules:
 * - The tree is a complete binary tree.
 * - In a max-heap, the parent node is always greater than or equal to its children.
 * - In a min-heap, the parent node is always less than or equal to its children.
 *
 * What doesn't make a heap:
 * - A tree that is not complete.
 * - A tree where the heap property is violated.
 *
 * Implementation:
 * - Heaps are commonly implemented using arrays.
 * - For a node at index i: ( index start from 0 )
 *   - Its left child is at index 2*i + 1.
 *   - Its right child is at index 2*i + 2.
 *   - Its parent is at index (i-1)/2.
 *
 * Representation:
 * - Heaps can be represented visually as a binary tree.
 * - Example of a max-heap:
 *       10
 *      /  \
 *     9    8
 *    / \  / \
 *   7  6 5  4
 *
 * Usage:
 * - Heaps are used in implementing priority queues.
 * - Heaps are used in heap sort algorithm.
 * - Heaps are used in graph algorithms like Dijkstra's shortest path algorithm.
 *
 * When to use:
 * - When you need quick access ( constant time ) to the largest or smallest element.
 * - When implementing a priority queue.
 * - When you need to sort elements efficiently.
 *
 * Time Complexity:
 * - Insertion: O(log n)
 * - Removal: O(log n)
 * - Accessing the root element: O(1)
 * 
 * Important points: ( here 'n' is size of heap )
 * - height : log(n)
 * - range of leaves : ( n/2 ) to ( n - 1 )
 * - range of intenal nodes : 0 to ( n/2 - 1 )
 * - Example of a max-heap:
 *       10
 *      /  \
 *     9    8
 *    / \  / \
 *   7   6 5  4
 * 
 *  - leaves : 3 to 6
 *  - internal nodes : 0 to 2 
 * 
 */


package com.datastructures.heaps;

import java.util.List;

public interface Heap {

    /**
     * Inserts an element into the heap.
     * This operation takes O(log n) time.
     *
     * @param val the value to be inserted into the heap
     */
    void insert(int val);

    /**
     * insert an array into the heap
     * this operation yakes O(n) time
     * 
     * @param arr is the array of integer elements
     */
    void insert(int[] arr);

    /**
     * Removes the root element from the heap.
     * This operation takes O(log n) time.
     *
     * @return the value of the removed element
     */
    int remove();

    /**
     * Sorts the elements of the heap using heap sort algorithm. 
     * This operation takes O(n log n) time.
     *
     * @return a sorted list of elements from the heap
     */
    List<Integer> heapSort();
}
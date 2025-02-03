package com.datastructures.heaps;

public class Main {
	public static void main(String[] args) {
		Max_Heap max_heap = new Max_Heap();
		max_heap.insert(20);
		max_heap.insert(2);
		max_heap.insert(25);
		max_heap.insert(34);
		max_heap.insert(45);
		max_heap.insert(62);
		max_heap.insert(52);
		max_heap.insert(70);
		
		System.out.println("get Max element : " + max_heap.max());
		max_heap.remove();
		System.out.println("get Max element : " + max_heap.max());
		max_heap.remove();
		System.out.println("get Max element : " + max_heap.max());
		max_heap.remove();
		System.out.println("get Max element : " + max_heap.max());

		max_heap.insert(new int[] { 1, 2, 8, 33, 21, 12, 7 });
		System.out.println("heap sort : " + max_heap.heapSort());
		System.out.println();

		Min_Heap min_heap = new Min_Heap();
		min_heap.insert(20);
		min_heap.insert(2);
		min_heap.insert(25);
		min_heap.insert(34);
		min_heap.insert(45);
		min_heap.insert(62);
		min_heap.insert(52);
		min_heap.insert(70);

		System.out.println("get Min element : " + min_heap.min());
		min_heap.remove();
		System.out.println("get Min element : " + min_heap.min());
		min_heap.remove();
		System.out.println("get Max element : " + min_heap.min());
		min_heap.remove();
		System.out.println("get Max element : " + min_heap.min());

		min_heap.insert(new int[] { 1, 2, 8, 33, 21, 12, 7 });
		System.out.println("heap sort : " + min_heap.heapSort());
		System.out.println();
	}
}

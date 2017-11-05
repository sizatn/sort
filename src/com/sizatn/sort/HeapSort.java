package com.sizatn.sort;

import java.util.ArrayList;

/**
 * 
 * @desc 堆排序
 * @author ZutaoShao
 * @date Nov 5, 2017
 */
public class HeapSort {

	public class Heap<E extends Comparable<E>> {
		ArrayList<E> list = new ArrayList<E>();

		/** Create a default heap */
		public Heap() {

		}

		/** Create a heap from an array of objects */
		public Heap(E[] objects) {
			for (int i = 0; i < objects.length; i++) {
				add(objects[i]);
			}
		}

		/** Add a new object into the heap */
		public void add(E e) {
			// Append to the heap
			list.add(e);

			// The index of the last node
			int currentIndex = list.size() - 1;

			while (currentIndex > 0) {
				int parentIndex = (currentIndex - 1) / 2;

				// Swap if the current object is greater than its parent
				if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
					E temp = list.get(currentIndex);
					list.set(currentIndex, list.get(parentIndex));
					list.set(parentIndex, temp);
				} else {
					// The tree is a heap now
					break;
				}

				currentIndex = parentIndex;
			}
		}

		/** Remove the root from the heap */
		public E remove() {
			if (list.size() == 0) {
				return null;
			}

			E removedObject = list.get(0);

			list.set(0, list.get(list.size() - 1));
			list.remove(list.size() - 1);

			int currentIndex = 0;
			while (currentIndex < list.size()) {
				int leftChildIndex = 2 * currentIndex + 1;
				int rightChildIndex = 2 * currentIndex + 2;

				// Find the maximum between two children
				if (leftChildIndex >= list.size()) {
					// The tree is a heap
					break;
				}

				int maxIndex = leftChildIndex;

				if (rightChildIndex < list.size()) {
					if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
						maxIndex = rightChildIndex;
					}
				}

				// Swap if the current node is less than the maximum
				if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
					E temp = list.get(maxIndex);
					list.set(maxIndex, list.get(currentIndex));
					list.set(currentIndex, temp);
					currentIndex = maxIndex;
				} else {
					// The tree is a heap
					break;
				}

			}
			return removedObject;
		}

		/** Get the number of nodes in the tree */
		public int getSize() {
			return list.size();
		}
	}
	
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		// Create a Heap of integers
		HeapSort hs = new HeapSort();
		Heap<E> heap = hs.new Heap<E>();
		
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
	
	public static void main(String[] args) {
		Integer[] list = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		heapSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

}

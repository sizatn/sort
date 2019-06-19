package com.sizatn.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @desc 堆排序是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 算法描述:
 * 1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 * @author sizatn
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
		Integer[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		heapSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}

}

package com.sizatn.sort;

/**
 * 
 * @desc 快速排序
 * @author sizatn
 * @date Nov 5, 2017
 */
public class QuickSort {

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	private static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	private static int partition(int[] list, int first, int last) {
		// Choose the first element as the pivot
		int pivot = list[first];
		// Index for forward search
		int low = first + 1;
		// Index for backward search
		int high = last;

		while (high > low) {
			// Search forward from left
			while (low <= high && list[low] <= pivot) {
				low++;
			}

			// Search backward from right
			while (low <= high && list[high] > pivot) {
				high--;
			}

			// Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high] >= pivot) {
			high--;
		}

		// Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
}

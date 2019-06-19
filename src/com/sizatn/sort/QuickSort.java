package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 快速排序
 * @author sizatn
 * @date Nov 5, 2017
 */
public class QuickSort {

	public static void quickSort(int[] arrs) {
		quickSort(arrs, 0, arrs.length - 1);
	}

	private static void quickSort(int[] arrs, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(arrs, first, last);
			quickSort(arrs, first, pivotIndex - 1);
			quickSort(arrs, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	private static int partition(int[] arrs, int first, int last) {
		// Choose the first element as the pivot
		int pivot = arrs[first];
		// Index for forward search
		int low = first + 1;
		// Index for backward search
		int high = last;

		while (high > low) {
			// Search forward from left
			while (low <= high && arrs[low] <= pivot) {
				low++;
			}

			// Search backward from right
			while (low <= high && arrs[high] > pivot) {
				high--;
			}

			// Swap two elements in the list
			if (high > low) {
				int temp = arrs[high];
				arrs[high] = arrs[low];
				arrs[low] = temp;
			}
		}

		while (high > first && arrs[high] >= pivot) {
			high--;
		}

		// Swap pivot with list[high]
		if (pivot > arrs[high]) {
			arrs[first] = arrs[high];
			arrs[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		quickSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}
}

package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 		将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * 算法描述：
 * 1.把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2.对这两个子序列分别采用归并排序；
 * 3.将两个排序好的子序列合并成一个最终的排序序列。
 * @author sizatn
 * @date Nov 5, 2017
 */
public class MergeSort {

	/** The method for sorting the numbers */
	public static void mergeSort(int[] arrs) {
		if (arrs.length > 1) {
			// Merge sort the first half
			int[] firstHalf = new int[arrs.length / 2];
			System.arraycopy(arrs, 0, firstHalf, 0, arrs.length / 2);
			mergeSort(firstHalf);
			
			// Merge sort the second half
			int secondHalfLength = arrs.length - arrs.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(arrs, arrs.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			// Merge firstHalf with secondHalf
			int[] temp = merge(firstHalf, secondHalf);
			System.arraycopy(temp, 0, arrs, 0, temp.length);
		}
	}

	/** Merge two sorted lists */
	private static int[] merge(int[] arrs1, int[] arrs2) {
		int[] temp = new int[arrs1.length + arrs2.length];
		
		// Current index in arrs1
		int current1 = 0;
		
		// Current index in arrs2
		int current2 = 0;
		
		// Current index in temp
		int current3 = 0;
		
		while (current1 < arrs1.length && current2 < arrs2.length) {
			if (arrs1[current1] < arrs2[current2]) {
				temp[current3++] = arrs1[current1++];
			} else {
				temp[current3++] = arrs2[current2++];
			}
		}
		while (current1 < arrs1.length) {
			temp[current3++] = arrs1[current1++];
		}
		
		while (current2 < arrs2.length) {
			temp[current3++] = arrs2[current2++];
		}
		return temp;
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		mergeSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}
	
}

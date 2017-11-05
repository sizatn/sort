package com.sizatn.sort;

/**
 * 
 * @desc 冒泡排序
 * @author sizatn
 * @date Nov 5, 2017
 */
public class BubbleSort {

	public static void bubbleSort(int[] list) {

		boolean needNextPass = true;

		for (int i = 1; i < list.length && needNextPass; i++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int j = 0; j < list.length - i; j++) {
				if (list[j] > list[j + 1]) {
					// swap list[j] with list[j + 1]
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					// next pass still needed
					needNextPass = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] list = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		bubbleSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
}

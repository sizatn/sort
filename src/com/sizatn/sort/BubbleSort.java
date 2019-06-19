package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 		走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * 算法描述：
 * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3.针对所有的元素重复以上的步骤，除了最后一个；
 * 4.重复步骤1~3，直到排序完成。
 * @author sizatn
 * @date Nov 5, 2017
 */
public class BubbleSort {

	public static void bubbleSort(int[] arrs) {

		// 是否需要下一次排序
		boolean needNextSort = true;

		for (int i = 1; i < arrs.length && needNextSort; i++) {
			// 数组可能已经排序，且不需要下一次的排序
			needNextSort = false;
			for (int j = 0; j < arrs.length - i; j++) {
				//  第一个值大于第二个值
				if (arrs[j] > arrs[j + 1]) {
					// 变量存储第一个值
					int temp = arrs[j];
					// 把第二个值赋值给第一个值
					arrs[j] = arrs[j + 1];
					// 把变量值赋值给第二个值
					arrs[j + 1] = temp;
					// 需要下一次排序
					needNextSort = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		bubbleSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}
}

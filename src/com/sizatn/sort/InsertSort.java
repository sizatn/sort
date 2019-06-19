package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 插入排序的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 1.从第一个元素开始，该元素可以认为已经被排序；
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 5.将新元素插入到该位置后；
 * 6.重复步骤2~5。
 * @author sizatn
 * @date Jun 19, 2019
 */
public class InsertSort {
	
	public static void insertSort(int[] arrs) {
		// 前一个值的索引
		int preIndex = 0;
		// 保存第i个值
		int current = 0;
		
		for (int i = 1; i < arrs.length; i++) {
			// 前一个值的索引
			preIndex = i - 1;
			// 保存第i个值(当前值)
			current = arrs[i];
			// 前一个值的索引大于等于0，且前一个值大于第i个值(当前值)
			while (preIndex >= 0 && arrs[preIndex] > current) {
				// 前一个值与后一个值互换
	            arrs[preIndex + 1] = arrs[preIndex];
	            preIndex--;
	        }
			// 最后一个值等于第i个值(当前值)
	        arrs[preIndex + 1] = current;
		}
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		insertSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}

}

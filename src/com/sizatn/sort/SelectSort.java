package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 		然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * 算法描述:
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * 1.初始状态：无序区为R[1..n]，有序区为空；
 * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n)。
 * 		该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区;
 * 3.n-1趟结束，数组有序化了。
 * @author sizatn
 * @date Jun 19, 2019
 */
public class SelectSort {
	
	public static void selectSort(int[] arrs) {
		// 索引
		int minIndex = 0;
		// 保存未排序的第一个值
		int temp = 0;
		
		for (int i = 0; i < arrs.length - 1; i++) {
			// 数组中未排序的第一个值的索引
			minIndex = i;
			for (int j = i + 1; j < arrs.length; j++) {
				// 从未排序的第二个值开始依次与未排序的第一个值比较，如果有小于未排序的第一个值则记录索引
				if (arrs[j] < arrs[minIndex]) {
					// 保存最小数的索引
					minIndex = j;
				}
			}
			// 将未排序的第一个值赋值给变量
			temp = arrs[i];
			// 将最小数的值赋值给未排序的第一个值
			arrs[i] = arrs[minIndex];
			// 将变量赋值给最小数索引
			arrs[minIndex] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		selectSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}

}

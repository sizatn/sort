package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2.按增量序列个数k，对序列进行k 趟排序；
 * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @author sizatn
 * @date Jun 19, 2019
 */
public class ShellSort {

	public static void shellSort(int[] arrs) {
		// len是步长
		int len = arrs.length;
		while (len != 1) {
			// 刚开始选择长度的一半作为步长，每次减少一半
			len = len / 2;
			// k是每个子序列的第一个元素的下标
			for (int k = 0; k <= len; k++) {
				// 通过改变i来改变倍数，确定下标
				for (int i = 1; k + i * len < arrs.length; i++) {
					// j是子序列中，小于i的所有下标
					for (int j = 0; j < i; j++) {
						// 子序列进行插入排序
						if (arrs[k + j * len] > arrs[k + i * len]) {
							int tmp = arrs[k + i * len];
							for (int p = i; p > j; p--) {
								arrs[k + p * len] = arrs[k + (p - 1) * len];
							}
							arrs[k + j * len] = tmp;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		shellSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}
}

package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 计数排序需要占用大量空间，它仅适用于数据比较集中的情况。比如 [0~100]，[10000~19999] 这样的数据。
 * 过程分析:
 * 1.计数排序的基本思想是：对每一个输入的元素arr[i]，确定小于 arr[i] 的元素个数。
 * 2.所以可以直接把 arr[i] 放到它输出数组中的位置上。假设有5个数小于 arr[i]，所以 arr[i] 应该放在数组的第6个位置上。
 * 
 * 需要三个数组:
 * 1.待排序数组 int[] arr = new int[]{4,3,6,3,5,1};
 * 2.辅助计数数组 int[] help = new int[max - min + 1]; //该数组大小为待排序数组中的最大值减最小值+1
 * 3.输出数组 int[] res = new int[arr.length];
 * 
 * 1.求出待排序数组的最大值max， 最小值min
 * 2.实例化辅助计数数组help，help用来记录每个元素之前出现的元素个数
 * 3.计算 arr 每个数字应该在排序后数组中应该处于的位置，此时 help = [1,1,4,5,6,7];
 * 4.根据 help 数组求得排序后的数组，此时 res = [1,3,3,4,5,6]
 * 
 * @author sizatn
 * @date Jun 19, 2019
 */
public class CountSort {

	public static int[] countSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		// 找出数组中的最大最小值
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		int[] help = new int[max - min + 1];

		// 找出每个数字出现的次数
		for (int i = 0; i < arr.length; i++) {
			int mapPos = arr[i] - min;
			help[mapPos]++;
		}

		// 计算每个数字应该在排序后数组中应该处于的位置
		for (int i = 1; i < help.length; i++) {
			help[i] = help[i - 1] + help[i];
		}

		// 根据help数组进行排序
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int post = --help[arr[i] - min];
			res[post] = arr[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		arrs = countSort(arrs);
		System.out.print(Arrays.toString(arrs));
	}
}

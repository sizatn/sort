package com.sizatn.sort;

import java.util.Arrays;

/**
 * 
 * @desc 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 桶排序的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 * 算法描述：
 * 1.设置一个定量的数组当作空桶；
 * 2.遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 3.对每个不是空的桶进行排序；
 * 4.从不是空的桶里把排好序的数据拼接起来。
 * @author sizatn
 * @date Jun 19, 2019
 */
public class BucketSort {

	public static void bucketSort(int[] arr) {
		// 寻找数组中min，max，用于建桶
		int min = 0, max = 0;
		
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("预处理信息：" + "min：" + min + " " + "max：" + max);
		
		// 开始建桶，注意桶的数量等于max - min + 1
		System.out.println("排序过程中桶状态：");
		int bucketCount = max - min + 1;
		System.out.println("桶个数：" + bucketCount + "，桶下标范围0~" + (bucketCount - 1));
		int[] bucket = new int[bucketCount];
		for (int i = 0; i <= arr.length - 1; i++) {
			bucket[arr[i] - min]++;
		}
		System.out.println(Arrays.toString(bucket));
		for (int i = 1; i < bucketCount; i++) {
			bucket[i] = bucket[i] + bucket[i - 1];
		}
		System.out.println(Arrays.toString(bucket));
		System.out.println();

		// 开始排序
		int[] copy = new int[arr.length];
		System.arraycopy(arr, 0, copy, 0, arr.length);

		// 从后往前排序，保持元素相对位置，保证算法稳定性。
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[--bucket[copy[i] - min]] = copy[i];
		}
		// 若从前往后排序，虽然排序结果相同，但会破坏元素相对位置和算法稳定性
		// for(int i = 0; i <= arr.length - 1; i++){
		// arr[--bucket[copy[i] - min]] = copy[i];
		// }
		System.out.println("排序后数组：" + Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] arrs = {2, 1, 3, 2, -5, 0, 7, -1, 14, 20, 12};
		bucketSort(arrs);
	}

}

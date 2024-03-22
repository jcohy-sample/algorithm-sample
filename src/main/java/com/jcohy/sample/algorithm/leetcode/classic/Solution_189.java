package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Solution_189 {

	private static void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
	}
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		rotate(new int[]{1,2,3,4,5,6,7},10);
	}
}

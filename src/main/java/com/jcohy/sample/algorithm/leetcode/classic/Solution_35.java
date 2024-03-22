package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.Arrays;

public class Solution_35 {

	public static int searchInsert(int[] nums, int target) {
		int answer = Arrays.binarySearch(nums, target);
		return answer >= 0 ? answer : -answer - 1;
	}

	public double[] convertTemperature(double celsius) {
		return new double[]{celsius+273.15,celsius*1.8 + 32.00};
	}
	public static void main(String[] args) {
//		System.out.println(searchInsert(new int[]{1,3,5,7},5));
		System.out.println(searchInsert(new int[]{1,3,5,7},2));
	}
}

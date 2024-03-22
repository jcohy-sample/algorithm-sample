package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.Arrays;

public class Solution_283 {

	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
		int s=0;//定义收集不是0的数的指针
		//开始收集不是零的数
		for (int i = 0; i < nums.length ;i++) {
			if(nums[i]!=0){
				nums[s++] = nums[i];
			}
		}
		//收集完毕后,后面自然就都是0了
		for (int i = s; i < nums.length; i++) {
			nums[i]=0;
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		moveZeroes(new int[]{0,1,0,3,12});
	}
}

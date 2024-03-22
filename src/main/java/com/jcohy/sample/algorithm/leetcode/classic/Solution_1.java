package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				return new int[]{i, map.get(target-nums[i])};
			}
			map.put(nums[i], i);
		}
		return new int[]{};
	}

	public static int[] twoSum2(int[] nums, int target) {
		for(int i=1;i<nums.length;i++){
			for(int j=i;j<nums.length;j++){
				if(nums[j-i]+nums[j]==target){
					return new int[]{j-i,j};
				}
			}
		}
		return new int[]{};
	}

	public static void main(String[] args) {
//		twoSum2(new int[]{2,7,11,15},9);
		twoSum2(new int[]{3,2,4},7);
	}
}

package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 */
public class Solution_80 {

    public static int removeDuplicates(int[] nums) {
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[count-2]) {
                nums[count++]=nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}

package com.jcohy.sample.algorithm.leetcode.classic;

/**
 *
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution_169 {

    public static int majorityElement(int[] nums) {

        int count = 1;
        int pero = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (pero == nums[i]) {
                count ++;
            } else if (-- count == 0) {
                pero = nums[i];
                count = 1;
            }
        }
        System.out.println(pero);
        return pero;
    }

    public static void main(String[] args) {
        majorityElement(new int[]{2,2,1,1,1,2,2});
    }
}

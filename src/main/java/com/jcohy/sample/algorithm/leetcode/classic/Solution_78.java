package com.jcohy.sample.algorithm.leetcode.classic;

import org.springframework.util.StopWatch;

import java.util.*;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @author jiac
 * @version 2023.0.1 2024/3/29:22:31
 * @since 2023.0.1
 */
public class Solution_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯算法。
     * 使用回溯算法，递归地构建子集。
     * 在每一步，可以选择将当前元素加入子集或者不加入子集。
     * 遍历完整个数组，即可得到所有可能的子集。
     * 时间复杂度为 O(2^N)，其中 N 是数组 nums 的长度。
     * 空间复杂度为 O(N * 2^N)，即存储所有子集的空间。
     * @param nums
     * @param start
     * @param path
     * @param result
     */
    private static void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }


    /**
     * 我们使用了位运算来生成所有可能的子集。
     * 使用位运算，将数组的每个元素的选取状态表示为一个二进制数。
     * 对于长度为 N 的数组，一共有 2^N 种可能的子集，每种子集由对应的一个二进制数表示。
     * 遍历所有可能的二进制数，根据每个二进制数的每一位是否为 1，将对应元素加入到子集中。
     *
     * 外层循环遍历了从 0 到 2^n-1 的所有数字，内层循环则检查每个数字的每一位，如果该位为 1，则将对应的元素加入到子集中。这种方法避免了递归，更加高效。
     * 时间复杂度为 O(N * 2^N)，其中 N 是数组 nums 的长度。
     * 空间复杂度为 O(N * 2^N)，即存储所有子集的空间。
     *
     * 第二种方法比第一种方法快的主要原因是因为它避免了递归。在第一种方法中，使用了回溯算法，每次都要递归调用函数，并且在函数调用的过程中需要创建和销毁函数调用栈，这会引入额外的开销。
     * 而在第二种方法中，使用了位运算来生成所有可能的子集，这种方法不需要递归，只需要通过循环遍历所有可能的组合。因此，它减少了函数调用和栈空间的开销，从而更加高效。
     * 此外，第二种方法也减少了内存的使用，因为不需要创建额外的列表来存储每个子集的路径，而是直接根据位运算结果来构建子集，节省了内存消耗。
     * 综上所述，第二种方法相比于第一种方法更加高效是因为它避免了递归调用和额外的内存开销。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    /**
     * 这种方法使用栈模拟递归的过程，将新生成的子集压入栈中，直到遍历完整个数组。最后，将栈中的元素依次弹出，即得到所有可能的子集。
     * 时间复杂度和空间复杂度与之前介绍的方法相同。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(new ArrayList<>()); // 初始为空集

        for (int num : nums) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(stack.get(i));
                subset.add(num);
                stack.push(subset);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }



    public static void main(String[] args) {
        Solution_78 solution78 = new Solution_78();
//        int[] nums = {1, 2, 3,5,4,66,77,35,23,423,53};
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0};
        StopWatch watch = new StopWatch();

        watch.start("subsets1 --> nums1");
        List<List<Integer>> subsets1nums1 = solution78.subsets(nums1);
        watch.stop();
        watch.start("subsets2 --> nums1");
        List<List<Integer>> subsets2nums1 = solution78.subsets2(nums1);
        watch.stop();
        watch.start("subsets3 --> nums1");
        List<List<Integer>> subsets3nums1 = solution78.subsets3(nums1);
        watch.stop();

        watch.start("subsets1 --> nums2");
        List<List<Integer>> subsets1nums2 = solution78.subsets(nums2);
        watch.stop();
        watch.start("subsets2 --> nums1");
        List<List<Integer>> subsets2nums2 = solution78.subsets2(nums2);
        watch.stop();
        watch.start("subsets3 --> nums1");
        List<List<Integer>> subsets3nums2 = solution78.subsets3(nums2);
        watch.stop();

        System.out.println(watch.prettyPrint());
        System.out.println(subsets1nums1);
        System.out.println(subsets2nums1);
        System.out.println(subsets3nums1);
        System.out.println(subsets1nums2);
        System.out.println(subsets2nums2);
        System.out.println(subsets3nums2);
        // result
        //---------------------------------------------
        //ns         %     Task name
        //---------------------------------------------
        //000091500  028%  subsets1 --> nums1
        //000009917  003%  subsets2 --> nums1
        //000221459  067%  subsets3 --> nums1
        //000003708  001%  subsets1 --> nums2
        //000001375  000%  subsets2 --> nums1
        //000004541  001%  subsets3 --> nums1
        //
        //[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        //[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
        //[[1, 2, 3], [2, 3], [1, 3], [3], [1, 2], [2], [1], []]
        //[[], [0]]
        //[[], [0]]
        //[[0], []]
    }
}

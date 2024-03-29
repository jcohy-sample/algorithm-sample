package com.jcohy.sample.algorithm.leetcode.classic;

import org.springframework.util.StopWatch;

import java.util.*;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * @author jiac
 * @version 2023.0.1 2024/3/29:22:51
 * @since 2023.0.1
 */
public class Solution_491 {


    /**
     * 1、定义一个递归函数 backtrack，用来生成递增子序列。
     * 2、在 backtrack 函数中，首先判断当前子序列的长度是否大于等于2，如果是，则将其加入结果集。
     * 3、使用一个 Set 来记录当前层已经选择过的元素，避免重复选择。
     * 4、遍历数组 nums，从 start 索引开始，进行选择。
     * 5、如果当前元素已经被选择过，则跳过。
     * 6、如果当前元素大于等于当前子序列的最后一个元素，则将其加入当前子序列中，并继续向后递归选择下一个元素。
     * 7、递归完成后，回溯，将当前选择的元素移除，继续尝试其他选择。
     * 8、最终返回结果集。
     * 时间复杂度分析：假设数组 nums 的长度为 N，生成的递增子序列的数量是 M，则时间复杂度为 O(2^N * M)，其中 2^N 是生成所有可能子集的数量，M 是复制子序列的时间复杂度。
     *
     * 空间复杂度分析：递归调用栈的最大深度是 N，每次递归都会创建一个当前子序列的拷贝，所以空间复杂度为 O(N * M)，其中 N 是数组 nums 的长度，M 是生成的递增子序列的数量。
     * @param nums
     * @return
     */
        public List<List<Integer>> findSubsequences1(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
            // 如果当前子序列长度大于等于2，则将其加入结果集
            if (current.size() >= 2) {
                result.add(new ArrayList<>(current));
            }

            // 使用 Set 来记录当前层已经选择过的元素，避免重复选择
            Set<Integer> used = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                // 如果当前元素已经被选择过，则跳过
                if (used.contains(nums[i])) {
                    continue;
                }
                // 如果当前元素大于等于当前子序列的最后一个元素，则将其加入当前子序列中
                if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                    current.add(nums[i]);
                    // 继续向后递归选择下一个元素
                    backtrack(nums, i + 1, current, result);
                    // 回溯，将当前选择的元素移除，继续尝试其他选择
                    current.remove(current.size() - 1);
                    // 标记当前元素为已选择
                    used.add(nums[i]);
                }
            }
    }


    /**
     * 该实现方案使用迭代方法生成所有可能的递增子序列，通过遍历数组中的每个元素，并使用位运算来确定该元素是否应该加入当前子序列。然后，再根据生成的子序列长度和内容，将其加入结果集中。
     * 时间复杂度分析：假设数组 nums 的长度为 N，则时间复杂度为 O(2^N * M)，其中 2^N 是生成所有可能子集的数量，M 是复制子序列的时间复杂度。
     * 空间复杂度分析：由于使用了一个 HashSet 来存储结果，以及迭代过程中生成的临时子序列，因此空间复杂度为 O(2^N * M)，其中 2^N 是生成的所有可能子集的数量，M 是生成的递增子序列的平均长度。
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        // 迭代生成所有可能的递增子序列
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> sequence = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // 如果第 j 位被选中，则将 nums[j] 加入当前子序列
                if ((i & (1 << j)) > 0) {
                    // 如果当前子序列为空或者 nums[j] 大于等于当前子序列的最后一个元素，则加入当前子序列
                    if (sequence.isEmpty() || nums[j] >= sequence.get(sequence.size() - 1)) {
                        sequence.add(nums[j]);
                    } else {
                        // 如果 nums[j] 小于当前子序列的最后一个元素，则跳过该子序列
                        break;
                    }
                }
            }
            // 如果当前子序列的长度大于等于2，则加入结果集
            if (sequence.size() >= 2) {
                result.add(new ArrayList<>(sequence));
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 该实现方案使用深度优先搜索（DFS）来生成所有可能的递增子序列，同时利用剪枝技巧来优化搜索过程，避免生成重复的子序列。
     * 时间复杂度分析：假设数组 nums 的长度为 N，则时间复杂度为 O(2^N * M)，其中 2^N 是生成所有可能子集的数量，M 是复制子序列的时间复杂度。
     * 空间复杂度分析：递归调用栈的最大深度是 N，同时还需要额外的空间来存储结果集，因此空间复杂度为 O(2^N * M)，其中 N 是数组 nums 的长度，M 是生成的递增子序列的平均长度。
     * 最优解：在给定问题的条件下，回溯算法、迭代法、动态规划和深度优先搜索都是合理且有效的解决方案，哪种方法更优取决于实际情况和个人偏好。
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences3(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, result);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, List<Integer> path, Set<List<Integer>> result) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                dfs(nums, i + 1, path, result);
                path.remove(path.size() - 1);
                used.add(nums[i]);
            }
        }
    }


    /**
     * 该实现方案使用广度优先搜索（BFS）来生成所有可能的递增子序列。首先，将每个元素作为起点加入队列，然后不断扩展当前序列，向后添加符合条件的元素，直到队列为空为止。
     * 时间复杂度分析：假设数组 nums 的长度为 N，则时间复杂度为 O(2^N * M)，其中 2^N 是生成所有可能子集的数量，M 是复制子序列的时间复杂度。
     * 空间复杂度分析：由于使用了一个队列来存储扩展的子序列，以及一个 HashSet 来存储结果，因此空间复杂度为 O(2^N * M)，其中 N 是数组长度，M 是平均子序列长度。
     * 这种方法与其他方法相比可能更适合于需要一步一步扩展序列的场景，而且能够有效地避免生成重复的子序列。
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        // 初始化，将所有可能的起始点加入队列
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new Pair(i, new ArrayList<>(List.of(nums[i]))));
        }

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentIndex = current.index;
            List<Integer> currentSeq = current.sequence;

            // 将当前子序列加入结果集
            if (currentSeq.size() >= 2) {
                result.add(new ArrayList<>(currentSeq));
            }

            // 使用 Set 来去重
            Set<Integer> used = new HashSet<>();
            for (int i = currentIndex + 1; i < nums.length; i++) {
                // 避免重复
                if (!used.contains(nums[i]) && nums[i] >= currentSeq.get(currentSeq.size() - 1)) {
                    used.add(nums[i]);
                    List<Integer> newSeq = new ArrayList<>(currentSeq);
                    newSeq.add(nums[i]);
                    queue.offer(new Pair(i, newSeq));
                }
            }
        }

        return result;
    }

    private static class Pair {
        int index;
        List<Integer> sequence;

        Pair(int index, List<Integer> sequence) {
            this.index = index;
            this.sequence = sequence;
        }
    }


    /**
     * 另一个可能的实现方案是使用回溯算法结合状态压缩来实现。在这种方法中，我们可以使用一个二进制位来表示当前元素是否被选取，以此来生成所有可能的递增子序列。
     * 这种方法通过回溯的方式生成所有可能的递增子序列。在每一步中，我们选择当前元素加入路径，并在递归调用后撤销选择，以继续搜索其他可能的路径。
     * 时间复杂度分析：假设数组 nums 的长度为 N，则时间复杂度为 O(2^N * M)，其中 2^N 是生成所有可能子集的数量，M 是复制子序列的时间复杂度。
     * 空间复杂度分析：递归调用栈的最大深度是 N，同时还需要额外的空间来存储结果集，因此空间复杂度为 O(2^N * M)，其中 N 是数组 nums 的长度，M 是生成的递增子序列的平均长度。
     * 这种方法相比于前面提到的其他方法，更加直接和简洁，也能够有效地避免生成重复的子序列。
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences5(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, path, result);
        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, int index, List<Integer> path, Set<List<Integer>> result) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        // 使用一个 HashSet 来存储已经选择过的元素，避免重复选择
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            // 如果当前元素已经被选取过，则跳过
            if (used.contains(nums[i])) {
                continue;
            }
            // 如果当前路径为空，或者当前元素大于等于路径中最后一个元素，则可以将其加入路径
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                used.add(nums[i]);
                // 继续向下选择
                backtrack(nums, i + 1, path, result);
                // 回溯，撤销选择
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution_491 solution491 = new Solution_491();
        int[] nums1 = new int[]{4,6,7,7};
        int[] nums2 = new int[]{4,4,3,2,1};

        StopWatch watch = new StopWatch();
        watch.start("findSubsequences1 --> nums1");
        List<List<Integer>> findSubsequences1nums1 = solution491.findSubsequences1(nums1);
        watch.stop();
        watch.start("findSubsequences2 --> nums1");
        List<List<Integer>> findSubsequences2nums1 = solution491.findSubsequences2(nums1);
        watch.stop();
        watch.start("findSubsequences3 --> nums1");
        List<List<Integer>> findSubsequences3nums1 = solution491.findSubsequences3(nums1);
        watch.stop();
        watch.start("findSubsequences4 --> nums1");
        List<List<Integer>> findSubsequences4nums1 = solution491.findSubsequences4(nums1);
        watch.stop();
        watch.start("findSubsequences5 --> nums1");
        List<List<Integer>> findSubsequences5nums1 = solution491.findSubsequences5(nums1);
        watch.stop();

        watch.start("findSubsequences1 --> nums2");
        List<List<Integer>> findSubsequences1nums2 = solution491.findSubsequences1(nums2);
        watch.stop();
        watch.start("findSubsequences2 --> nums2");
        List<List<Integer>> findSubsequences2nums2 = solution491.findSubsequences2(nums2);
        watch.stop();
        watch.start("findSubsequences3 --> nums2");
        List<List<Integer>> findSubsequences3nums2 = solution491.findSubsequences3(nums2);
        watch.stop();
        watch.start("findSubsequences4 --> nums2");
        List<List<Integer>> findSubsequences4nums2 = solution491.findSubsequences4(nums2);
        watch.stop();
        watch.start("findSubsequences5 --> nums2");
        List<List<Integer>> findSubsequences5nums2 = solution491.findSubsequences5(nums2);
        watch.stop();

        System.out.println(watch.prettyPrint());

        System.out.println(findSubsequences1nums1);
        System.out.println(findSubsequences2nums1);
        System.out.println(findSubsequences3nums1);
        System.out.println(findSubsequences4nums1);
        System.out.println(findSubsequences5nums1);

        System.out.println(findSubsequences1nums2);
        System.out.println(findSubsequences2nums2);
        System.out.println(findSubsequences3nums2);
        System.out.println(findSubsequences4nums2);
        System.out.println(findSubsequences5nums2);
        // ---------------------------------------------
        //ns         %     Task name
        //---------------------------------------------
        //000058958  022%  findSubsequences1 --> nums1
        //000049750  019%  findSubsequences2 --> nums1
        //000035291  013%  findSubsequences3 --> nums1
        //000033000  012%  findSubsequences5 --> nums1
        //000014542  005%  findSubsequences1 --> nums2
        //000046041  017%  findSubsequences2 --> nums2
        //000015042  006%  findSubsequences3 --> nums2
        //000015792  006%  findSubsequences4 --> nums2
        //
        // result:
        //StopWatch '': running time = 776916 ns
        //---------------------------------------------
        //ns         %     Task name
        //---------------------------------------------
        //000057500  007%  findSubsequences1 --> nums1
        //000057042  007%  findSubsequences2 --> nums1
        //000040583  005%  findSubsequences3 --> nums1
        //000479708  062%  findSubsequences4 --> nums1
        //000037542  005%  findSubsequences5 --> nums1
        //000012708  002%  findSubsequences1 --> nums2
        //000043583  006%  findSubsequences2 --> nums2
        //000014083  002%  findSubsequences3 --> nums2
        //000017917  002%  findSubsequences4 --> nums2
        //000016250  002%  findSubsequences5 --> nums2
        //
        //[[4, 6], [4, 6, 7], [4, 6, 7, 7], [4, 7], [4, 7, 7], [6, 7], [6, 7, 7], [7, 7]]
        //[[7, 7], [6, 7], [4, 6], [4, 7, 7], [4, 6, 7, 7], [4, 7], [4, 6, 7], [6, 7, 7]]
        //[[7, 7], [6, 7], [4, 6], [4, 6, 7, 7], [4, 7, 7], [4, 6, 7], [4, 7], [6, 7, 7]]
        //[[4, 6], [4, 7], [6, 7], [7, 7], [4, 6, 7], [4, 7, 7], [6, 7, 7], [4, 6, 7, 7]]
        //[[7, 7], [6, 7], [4, 6], [4, 6, 7, 7], [4, 7, 7], [4, 6, 7], [4, 7], [6, 7, 7]]
        //[[4, 4]]
        //[[4, 4]]
        //[[4, 4]]
        //[[4, 4]]
        //[[4, 4]]
    }

}

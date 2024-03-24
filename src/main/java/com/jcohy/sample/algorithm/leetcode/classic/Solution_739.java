package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.Stack;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 2023.0.1 2024/3/24:22:35
 * @since 2023.0.1
 */
public class Solution_739 {

    /**
     * 你可以使用单调栈的方法来解决这个问题。遍历整个温度数组，把温度数组的索引入栈，如果当前温度大于栈顶索引的温度，
     * 说明找到了下一个更高温度的位置，将栈顶索引出栈并计算当前索引与栈顶索引之间的天数，即得到下一个更高温度出现的天数。
     * 不断重复这一过程直到温度数组遍历完毕。
     *
     * 这个算法的时间复杂度为 O(n)，其中 n 是输入数组 temperatures 的长度。在最坏情况下，算法需要遍历整个数组一次，并且每个元素最多被压栈和出栈一次。因此，时间复杂度为 O(n)。
     *
     * 空间复杂度为 O(n)，主要是由栈使用的额外空间导致的。在最坏情况下，栈可能会存储整个数组的索引，因此空间复杂度为 O(n)。
     *
     * 总结起来，这个算法的时间复杂度为 O(n)，空间复杂度为 O(n)。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;

    }
}

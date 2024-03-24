package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 2023.0.1 2024/3/24:22:28
 * @since 2023.0.1
 */
public class Solution_763 {

    /**
     * 要解决这个问题，可以使用贪心算法。首先遍历一次字符串 s，记录每个字母最后出现的位置。然后再遍历一次字符串 s，
     * 维护一个当前片段的起始位置 start 和结束位置 end，如果当前遍历到的字符的最后出现位置大于 end，就更新 end。如果当前位置等于 end，
     * 则说明当前片段已经结束，将当前片段的长度加入结果列表，并更新 start 为下一个位置。
     *
     * 这段代码使用了贪心算法，只需遍历字符串两次，时间复杂度为 O(n)，其中 n 是字符串 s 的长度。算法非常高效且简洁，能够快速求解问题。
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}

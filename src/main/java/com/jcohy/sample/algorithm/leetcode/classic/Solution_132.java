package com.jcohy.sample.algorithm.leetcode.classic;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 2023.0.1 2024/3/24:22:32
 * @since 2023.0.1
 */
public class Solution_132 {

    /**
     * 要解决这个问题，可以使用动态规划算法。首先，可以使用动态规划预处理出字符串 s 中任意子串是否为回文串的信息，然后再利用动态规划来找到最少的分割次数。
     *
     * 时间复杂度为 O(n^2)，其中 n 是字符串 s 的长度。
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = j; // 最坏情况下，分割次数最多为 j
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    dp[j] = (i == 0) ? 0 : Math.min(dp[j], dp[i - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}

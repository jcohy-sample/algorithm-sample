package com.jcohy.sample.algorithm.leetcode.classic;

import org.springframework.util.StopWatch;

import java.util.List;

/**
 * <p> Description:
 *
 * @author jiac
 * @since 2024/4/8 11:56
 */
public class Solution_541 {

    public String reverseStr1(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i += 2 * k) {
            // 反转前 k 个字符
            reverse(chars, i, Math.min(i + k, n) - 1);
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseStr2(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += 2 * k) {
            int end = Math.min(i + k, n);
            // 反转前 k 个字符
            result.append(reverse(s.substring(i, end)));

            // 将剩余字符直接加入结果中
            result.append(s, end, Math.min(end + k, n));
        }

        return result.toString();
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Solution_541 solution = new Solution_541();
        String str1 = "abcdefg";
        String str2 = "abcd";
        int k1 = 2;

        StopWatch watch = new StopWatch();
        watch.start("reverseStr1 --> str1");
        String reverse1Str1 = solution.reverseStr1(str1,k1);
        watch.stop();
        watch.start("reverseStr2 --> str1");
        String reverse2Str1 = solution.reverseStr2(str1,k1);
        watch.stop();

        watch.start("reverseStr1 --> str2");
        String reverse1Str2 = solution.reverseStr1(str2,k1);
        watch.stop();
        watch.start("reverseStr2 --> str2");
        String reverse2Str2 = solution.reverseStr2(str2,k1);
        watch.stop();

        System.out.println(watch.prettyPrint());

        System.out.println(reverse1Str1);
        System.out.println(reverse2Str1);
        System.out.println(reverse1Str2);
        System.out.println(reverse2Str2);

        // print
        // ---------------------------------------------
        // ns         %     Task name
        // ---------------------------------------------
        // 000044600  060%  reverseStr1 --> str1
        // 000025000  034%  reverseStr2 --> str1
        // 000002400  003%  reverseStr1 --> str2
        // 000002500  003%  reverseStr2 --> str2
        //
        // bacdfeg
        // bacdfeg
        // bacd
        // bacd
    }
}

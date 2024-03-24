package com.jcohy.sample.algorithm.leetcode.classic;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 2023.0.1 2024/3/24:22:23
 * @since 2023.0.1
 */
public class Solution_383 {

    /**
     * 最优解是使用数组来记录 magazine 中的字符数量，然后遍历 ransomNote 字符串时，逐一减少对应字符的数量。
     *
     * 这个解决方案中，我们利用了一个长度为 26 的整型数组 charCount 来记录 magazine 中每个字母出现的次数。
     * 然后我们遍历 ransomNote，如果对应字母的数量大于 0，就将该字母的数量减 1；如果对应字母的数量等于 0 或者小于 0，
     * 就返回 false。遍历结束后，如果没有返回 false，则说明 ransomNote 可以由 magazine 中的字符构成，返回 true。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] > 0) {
                charCount[c - 'a']--;
            } else {
                return false;
            }
        }

        return true;
    }

}

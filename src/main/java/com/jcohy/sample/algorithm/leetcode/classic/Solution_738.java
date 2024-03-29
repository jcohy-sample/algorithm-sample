package com.jcohy.sample.algorithm.leetcode.classic;

import org.springframework.util.StopWatch;

import java.util.List;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 输入: n = 10
 * 输出: 9
 * 输入: n = 1234
 * 输出: 1234
 * 输入: n = 332
 * 输出: 299
 *
 * @author jiac
 * @version 2023.0.1 2024/3/29:22:46
 * @since 2023.0.1
 */
public class Solution_738 {

    /**
     * 暴力法
     * 时间复杂度：O(N * M)，其中 N 是 n 的位数，M 是 isMonotone 方法的时间复杂度，为 O(N)。
     * 空间复杂度：O(N)，主要是由于将整数转换为字符串所需的空间。
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        while (!isMonotone(n)) {
            n--;
        }
        return n;
    }

    private boolean isMonotone(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 贪心法
     *
     * 1、将整数转换为字符数组，以便对每一位进行处理。
     * 2、从后向前遍历数组，找到第一个位置 i，满足 digits[i-1] > digits[i]，记录这个位置为 marker。
     * 3、将 marker 位置的数字减一，并将 marker 位置后面的所有数字置为9。
     * 4、将修改后的字符数组转换为整数并返回。
     *
     * 整数转换为字符数组需要O(logn)的时间复杂度，其中 n 是输入整数的位数。遍历字符数组找到 marker 的过程需要O(logn)的时间复杂度。将 marker 位置后面的数字置为9需要O(logn)的时间复杂度。最后将字符数组转换为整数需要O(logn)的时间复杂度。
     * 综合起来，算法的时间复杂度为O(logn)。
     * 空间复杂度分析：需要额外的空间来存储字符数组，空间复杂度为O(logn)。
     * 该方法只需要一次遍历整数的每一位，并在遍历过程中进行递减，以确保最后得到的数字是单调递增的。然后，将递减点后的所有数字置为 9，即可得到最终结果。
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits2(int n) {
        // 将整数转换为字符数组
        char[] digits = Integer.toString(n).toCharArray();
        // 记录需要修改的位置
        int marker = digits.length;

        // 从后向前遍历数组，找到需要修改的位置
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                marker = i - 1;
                digits[i - 1]--;
            }
        }

        // 将需要修改位置后面的数字全部置为9
        for (int i = marker + 1; i < digits.length; i++) {
            digits[i] = '9';
        }

        // 将字符数组转换为整数并返回
        return Integer.parseInt(new String(digits));
    }


    /**
     * 数学方法来直接构造单调递增的数字。
     * 1、从个位开始，逐位构造单调递增的数字。
     * 2、初始化变量 prevDigit 为 9，表示前一位的数字初始值为 9。
     * 3、从个位开始向高位遍历输入的整数 n。
     * 4、如果当前位的数字小于等于 prevDigit，直接将其加入结果。
     * 5、如果当前位的数字大于 prevDigit，则将当前位的数字减一，同时将后续所有位都设置为9，然后构造结果。
     * 6、最后返回结果。
     * 时间复杂度分析：这种方法只需要一次遍历输入的整数，因此时间复杂度为 O(logn)，其中 n 是输入整数的位数。
     * 空间复杂度分析：这种方法不需要额外空间，因此空间复杂度为 O(1)。
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits3(int n) {
        // 从个位开始，逐位构造单调递增的数字
        int num = n;
        int prevDigit = 9; // 上一位的数字
        int result = 0; // 结果

        // 从个位开始向高位遍历
        int base = 1;
        while (num > 0) {
            int digit = num % 10; // 当前位的数字
            num /= 10;

            // 如果当前位数字大于上一位数字，直接加入结果
            if (digit <= prevDigit) {
                result += digit * base;
                prevDigit = digit;
            } else {
                // 如果当前位数字大于上一位数字，需要调整结果
                result = digit * base - 1;
                prevDigit = digit - 1;
            }
            base *= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_738 solution738 = new Solution_738();
        int nums1 = 10;
        int nums2 = 1234;
        int nums3 = 332;
        StopWatch watch = new StopWatch();
        watch.start("monotoneIncreasingDigits1 --> nums1");
        int monotoneIncreasingDigits1nums1 = solution738.monotoneIncreasingDigits(nums1);
        watch.stop();
        watch.start("monotoneIncreasingDigits2 --> nums1");
        int monotoneIncreasingDigits2nums1 = solution738.monotoneIncreasingDigits2(nums1);
        watch.stop();
        watch.start("monotoneIncreasingDigits3 --> nums1");
        int monotoneIncreasingDigits3nums1 = solution738.monotoneIncreasingDigits3(nums1);
        watch.stop();

        watch.start("monotoneIncreasingDigits1 --> nums2");
        int monotoneIncreasingDigits1nums2 = solution738.monotoneIncreasingDigits(nums2);
        watch.stop();
        watch.start("monotoneIncreasingDigits2 --> nums2");
        int monotoneIncreasingDigits2nums2 = solution738.monotoneIncreasingDigits2(nums2);
        watch.stop();
        watch.start("monotoneIncreasingDigits3 --> nums2");
        int monotoneIncreasingDigits3nums2 = solution738.monotoneIncreasingDigits3(nums2);
        watch.stop();

        watch.start("monotoneIncreasingDigits1 --> nums3");
        int monotoneIncreasingDigits1nums3 = solution738.monotoneIncreasingDigits(nums3);
        watch.stop();
        watch.start("monotoneIncreasingDigits2 --> nums3");
        int monotoneIncreasingDigits2nums3 = solution738.monotoneIncreasingDigits2(nums3);
        watch.stop();
        watch.start("monotoneIncreasingDigits3 --> nums3");
        int monotoneIncreasingDigits3nums3 = solution738.monotoneIncreasingDigits3(nums3);
        watch.stop();
        System.out.println(watch.prettyPrint());

        System.out.println(monotoneIncreasingDigits1nums1);
        System.out.println(monotoneIncreasingDigits2nums1);
        System.out.println(monotoneIncreasingDigits3nums1);

        System.out.println(monotoneIncreasingDigits1nums2);
        System.out.println(monotoneIncreasingDigits2nums2);
        System.out.println(monotoneIncreasingDigits3nums2);

        System.out.println(monotoneIncreasingDigits1nums3);
        System.out.println(monotoneIncreasingDigits2nums3);
        System.out.println(monotoneIncreasingDigits3nums3);

        // result
        //---------------------------------------------
        //ns         %     Task name
        //---------------------------------------------
        //000016125  005%  monotoneIncreasingDigits1 --> nums1
        //000226084  070%  monotoneIncreasingDigits2 --> nums1
        //000001542  000%  monotoneIncreasingDigits3 --> nums1
        //000002709  001%  monotoneIncreasingDigits1 --> nums2
        //000003750  001%  monotoneIncreasingDigits2 --> nums2
        //000000708  000%  monotoneIncreasingDigits3 --> nums2
        //000066792  021%  monotoneIncreasingDigits1 --> nums3
        //000005042  002%  monotoneIncreasingDigits2 --> nums3
        //000000875  000%  monotoneIncreasingDigits3 --> nums3
        //
        //9
        //9
        //9
        //1234
        //1234
        //1234
        //299
        //299
        //299
    }
}

package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;
// tag::code[]
/**
 * 公约数个数
 * 公约数，亦称"公因数"。它是指能同时整除几个整数的数。如果一个整数同时是几个整数的约数，称这个整数为它们的"公约数"；公约数中最大的称为最大公约数。
 */
public class Test_1084 {
    public static void main(String[] args) {
        long a, b;
        int m = 0;
        Scanner in = new Scanner(System.in);
        long[] arr = new long[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = in.nextLong();
        }
        for (int i = 0; i < 4; i += 2) {
            m = count(arr[i], arr[i + 1]);
            System.out.println(m);
        }

    }

    public static int count(long a, long b) {
        int count = 0;
        for (long i = 1; i <= a; i++) {
            if ((a % i) == 0) {
                if ((b % i) == 0) {
                    count++;

                }
            }
        }
        return count;
    }
    /**
     * 输入：
     * 3
     * 9
     * 5
     * 4
     * 输出：
     * 2
     * 1
     */
}
// end::code[]
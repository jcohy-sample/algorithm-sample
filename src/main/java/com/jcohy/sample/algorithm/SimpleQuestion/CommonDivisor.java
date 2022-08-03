package com.jcohy.sample.algorithm.SimpleQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// tag::code[]
/**
 * 题目: 输入两个正整数 m 和 n，求其最大公约数和最小公倍数。
 * 利用辗除法
 */
public class CommonDivisor {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int m = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
//			System.out.println(commonDivisor(m,n));
            int divisor = commonDivisor(m, n);
            System.out.println("最大公约数: " + divisor + "\n" + "最小公倍数: " + m * n / divisor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int commonDivisor(int m, int n) {
//		if(m<0||n<0)
//			return -1;
//		if(n==0)
//			return m;
//		return commonDivisor(n,m%n);
        while (true) {
            if ((m = m % n) == 0) {
                return n;
            }
            if ((n = n % m) == 0) {
                return m;
            }
        }
    }
    /**
     * 输入：25
     * 输出：
     * 最大公约数: 5
     * 最小公倍数: 75
     */
}
// end::code[]

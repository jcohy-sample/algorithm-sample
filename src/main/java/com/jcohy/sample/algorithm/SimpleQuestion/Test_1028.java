package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;
// tag::code[]
/**
 * 判断素数
 * 素数是指质数，一个大于1的自然数，除了1 和它自身外，不能整除其他自然数的数叫做质数；否则称为合数。
 */
public class Test_1028 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        if (isPrime(p)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }

    public static boolean isPrime(int p) {

        if (p < 2) {
            return false;
        }
        if (p == 2) {
            return true;
        }
        for (int i = 2; i * i <= p; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;

    }
    /**
     * 输入：5
     * 输出：prime
     */
}
// end::code[]
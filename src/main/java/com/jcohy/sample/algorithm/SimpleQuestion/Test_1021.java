package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// tag::code[]
/**
 * 筛法求之 N 内的素数
 */
public class Test_1021 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<String> list = new ArrayList<>();
        list.add("2");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                list.add(String.valueOf(i));
            }
        }
        for (String s : list) {
            System.out.print(s + " ");
        }
        /**
         * 输入：6
         * 输出：2 3 5
         */
    }

    private static boolean isPrime(int num) {
        if (num <= 2 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
// end::code[]

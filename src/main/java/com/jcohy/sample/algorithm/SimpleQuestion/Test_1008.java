package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;
// tag::code[]
/**
 * 简单数字操作
 */
public class Test_1008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一串数字: ");
        String a = in.nextLine();
        System.out.println("数字长度:" + a.length());
        System.out.print("数字拆分: ");
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.charAt(i) + " ");
        }
        System.out.println();
        System.out.print("数字逆序:");
        for (int i = a.length() - 1; i >= 0; i--) {
            System.out.print(a.charAt(i));
        }
    }
    /**
     * 输出：
     * 请输入一串数字：2135
     * 数字长度:4
     * 数字拆分: 2 1 3 5
     * 数字逆序:5312
     */
}
// end::code[]
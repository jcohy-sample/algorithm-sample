package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;

// tag::code[]
/**
 * 数组插入
 * 从后往前插入，插入位置为第一个小于插入元素的后面
 */
public class Test_1024 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[5];
        System.out.println("请输入数组元素：");
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = in.nextInt();
        }
        System.out.println("请输入插入元素：");
        int insert = in.nextInt();
        for (int i = a.length - 2; i > 0; i--) {
            if (a[i] > insert) {
                a[i + 1] = a[i];
            } else {
                a[i + 1] = insert;
                break;
            }
        }
        System.out.println("插入后元素：");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    /**
     * 输入： 4 2 1 6
     * 插入元素：3
     * 插入后数组：4 2 1 3 6
     */
}
// end::code[]

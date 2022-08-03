package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;

// tag::code[]
/**
 * 有n个人围成一圈，按顺序从1到n编好号。从第一个人开始报数，报到3的人退出圈子，下一个人从1开始报数，报到3的人退出圈子。如此下去，直到留下最后一个人。请按退出顺序输出退出圈子的人的编号。
 */
public class Test_1046 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入一个整数 n 个人：");
        int n = scan.nextInt();
        int a[] = new int[n];
        int last = baoshu(a);
//        System.out.println(last);
    }

    private static int baoshu(int[] a) {
        int count = 0;
        int overTag = 0;
        int last = 0;
        do {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) {
                    count++;
                    if (count % 3 == 0) {
                        a[i] = 1;
                        overTag++;
                        System.out.println((i +1) + " 号退出！");
                    }
                    last = i;
                }
            }
        } while (overTag != a.length);

        return last + 1;
    }
    /**
     * 输入
     * 输入一个整数 n 个人：5
     * 输出：
     * 3 号退出！
     * 1 号退出！
     * 5 号退出！
     * 2 号退出！
     * 4 号退出！
     */
}
// end::code[]
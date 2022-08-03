package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;

// tag::code[]
/**
 * 一只小猴子一天摘了许多桃子，第一天吃了一半，然后忍不住又吃了一个；
 * 第二天又吃了一半，再加上一个；后面每天都是这样吃。到第 n 天的时候，小猴子发现只有一个桃子了。问小猴子第一天共摘了多少个桃子。
 */
public class Test_1019 {

    //猴子吃桃问题
    public static void main(String[] agrs) {
        System.out.println("请输入天数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 1;
        for (int i = 2; i <= n; i++) {
            count = (count + 1) * 2;
        }
        System.out.println(count);
    }
    /**
     * 输入：10
     * 输出：1534
     */
}
// end::code[]
package com.jcohy.sample.algorithm.SimpleQuestion;

import java.text.DecimalFormat;
import java.util.Scanner;

// tag::code[]
/**
 * 三角形面积
 * 海伦公式：有一个三角形，边长分别为a、b、c，三角形的面积S可由以下公式求得：
 * S = sqrt(p(p-a)(p-b)(p-c)),其中 p = (a + b + c)/2
 */
public class Test_1037 {
    public static void main(String[] agrs) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        final double S = (a + b + c) / 2;
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(Math.sqrt((S * (S - a) * (S - b) * (S - c)))));
        /**
         * 输入
         * 3
         * 4
         * 5
         * 输出
         * 6
         */
    }
}
// end::code[]
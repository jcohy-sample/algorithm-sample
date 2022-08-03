package com.jcohy.sample.algorithm.SimpleQuestion;

import java.text.DecimalFormat;
import java.util.Scanner;

// tag::code[]
/**
 * 数去 3 个数 n1,n2,n3，计算 1+2+..+n1+1*1+2*2+...+n2*n2+1/2+1/2+...+1/n3 的和。
 */
public class Test_1014 {

    //求和缩略
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        double sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        for (int i = 1; i <= b; i++) {
            sum += (i * i);
        }
        for (double i = 1; i <= c; i++) {
            sum += (1 / i);
        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(sum));
    }
    /**
     * 输入：2 2 2
     * 输出：9.50
     */
}
// end::code[]
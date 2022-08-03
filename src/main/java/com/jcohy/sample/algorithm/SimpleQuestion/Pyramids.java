package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;

// tag::code[]
public class Pyramids {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入金字塔层数：");
        int a = in.nextInt();

        {
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 1 - i; j++) {
                    System.out.print(" ");
                }

                //输出 "* "
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
    /**
     * 请输入金字塔层数：6
     * 输出：
     *      *
     *     ***
     *    *****
     *   *******
     *  *********
     * ***********
     */
}
// end::code[]

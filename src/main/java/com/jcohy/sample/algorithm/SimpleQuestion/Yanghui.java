package com.jcohy.sample.algorithm.SimpleQuestion;

import java.util.Scanner;

// tag::code[]
public class Yanghui {

    public static void main(String[] agrs) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] arr = new int[count][];
        //初始化数组。
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }
        //显示出为每个元素赋值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][0] = arr[i][i] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i > 1 && j > 0 && j < i) {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.format("%" + (arr.length - i) * 2 + "s", "");
            for (int j = 0; j < arr[i].length; j++) {
                // 此方式为打印等边形状的杨辉三角
                System.out.format("%4d", arr[i][j]);
                // 此方式为打印直角形状的杨辉三角
                // System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    /**
     * 输入：10
     * 输出
     *                        1
     *                      1   1
     *                    1   2   1
     *                  1   3   3   1
     *                1   4   6   4   1
     *              1   5  10  10   5   1
     *            1   6  15  20  15   6   1
     *          1   7  21  35  35  21   7   1
     *        1   8  28  56  70  56  28   8   1
     *      1   9  36  84 126 126  84  36   9   1
     */
}
// end::code[]

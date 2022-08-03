package com.jcohy.sample.algorithm.SimpleQuestion;

import java.text.DecimalFormat;
import java.util.Scanner;

// tag::code[]
/**
 * 华氏温度转摄氏温度
 * 华氏温度用字母 "F"表示。. 它与摄氏温度（C）和华氏温度（F）之间的换算关系为 C = 5×（F- 32）/9，F = 9×C /5+32
 */
public class Test_1004 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        float b = 5 * (a - 32) / 9;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("c=" + df.format(b));
    }
}
// end::code[]
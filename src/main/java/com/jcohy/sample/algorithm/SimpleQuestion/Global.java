package com.jcohy.sample.algorithm.SimpleQuestion;

// tag::code[]
/**
 * 题目: 一球从 100 米高度自由落下，每次落地后反跳回原高度的一半;再落下，
 * 求它在 第 10 次落地时，共经过多少米? 第 10 次反弹多高?
 */
public class Global {

    public static void main(String[] args) {

        double height = 100;
        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += height;
            height = height / 2;
            sum += height;
        }
        System.out.println(height + " " + (sum + height));
    }
    /**
     * 输出：0.09765625 299.8046875
     */
}
// end::code[]
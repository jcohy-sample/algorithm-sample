package com.jcohy.sample.algorithm.sort;

/**
 * @author jcohy
 * @date 2019/2/15
 * ClassName  : com.jcohy.study.sort
 * Description  : 简单选择排序-改进
 */
// tag::code[]
public class SelectSort2 {
    public static void selectSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (data[minIndex] > data[j]) {
                    minIndex = j;

                }
            }
            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
            System.out.println(java.util.Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println("排序之前: \n" + java.util.Arrays.toString(data));
        selectSort(data);
        System.out.println("排序之后: \n" + java.util.Arrays.toString(data));
        /**
         * 排序之前:
         * [9, -16, 21, 23, -30, -49, 21, 30, 30]
         * 开始排序
         * [-49, -16, 21, 23, -30, 9, 21, 30, 30]
         * [-49, -30, 21, 23, -16, 9, 21, 30, 30]
         * [-49, -30, -16, 23, 21, 9, 21, 30, 30]
         * [-49, -30, -16, 9, 21, 23, 21, 30, 30]
         * [-49, -30, -16, 9, 21, 23, 21, 30, 30]
         * [-49, -30, -16, 9, 21, 21, 23, 30, 30]
         * [-49, -30, -16, 9, 21, 21, 23, 30, 30]
         * [-49, -30, -16, 9, 21, 21, 23, 30, 30]
         * 排序之后:
         * [-49, -30, -16, 9, 21, 21, 23, 30, 30]
         */
    }
}
// end::code[]

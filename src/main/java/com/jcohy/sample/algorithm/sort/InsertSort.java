package com.jcohy.sample.algorithm.sort;

/**
 * @author jcohy
 * @date 2019/2/15
 * ClassName  : com.jcohy.study.sort
 * Description  :
 */
// tag::code[]
public class InsertSort {

    public static void main(String[] args) {
        InsertSort quickSort = new InsertSort();
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println("排序之前: \n" + java.util.Arrays.toString(data));
        quickSort.insertSort(data);
        System.out.println("排序之后: \n" + java.util.Arrays.toString(data));
        // 排序之前:
        // [9, -16, 21, 23, -30, -49, 21, 30, 30]
        // 开始排序
        // 第1次比较: [-16, 9, 21, 23, -30, -49, 21, 30, 30]
        // 第2次比较: [-16, 9, 21, 23, -30, -49, 21, 30, 30]
        // 第3次比较: [-16, 9, 21, 23, -30, -49, 21, 30, 30]
        // 第4次比较: [-30, -16, 9, 21, 23, -49, 21, 30, 30]
        // 第5次比较: [-49, -30, -16, 9, 21, 23, 21, 30, 30]
        // 第6次比较: [-49, -30, -16, 9, 21, 21, 23, 30, 30]
        // 第7次比较: [-49, -30, -16, 9, 21, 21, 23, 30, 30]
        // 第8次比较: [-49, -30, -16, 9, 21, 21, 23, 30, 30]
        // 排序之后:
        // [-49, -30, -16, 9, 21, 21, 23, 30, 30]
    }

    private void insertSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        //扫描循环次数为SIZE-1,//i为扫描次数
        for (int i = 1; i < arrayLength; i++) {
            int temp = data[i];
            if (data[i] < data[i - 1]) {
                //以j来定位比较的元素
                int j = i - 1;
                ////如果第二元素小于第一元素,就把所有元素往后推一个位置
                for (; j >= 0 && data[j] > temp; j--) {
                    data[j + 1] = data[j];
                }
                //最小的元素放到第一个元素
                data[j + 1] = temp;
            }
            System.out.print("第" + i + "次比较: ");
            System.out.println(java.util.Arrays.toString(data));
        }
    }
}
// end::code[]

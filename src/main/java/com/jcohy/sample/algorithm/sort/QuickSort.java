package com.jcohy.sample.algorithm.sort;

/**
 * @author jcohy
 * @date 2019/2/15
 * ClassName  : com.jcohy.study.sort
 * Description  :   快速排序
 */
// tag::code[]
public class QuickSort {

    private int process = 0;

    private void subSort(int[] data, int left, int right) {
        if (left < right ) {
            int lf = left;
            int rg = right + 1;
            int pivot = data[left];
            process ++;
            System.out.println("[基准值] => " + pivot + ",[排序数组索引范围] => " + left + "-" + right);
            showData(data,"数组");
            while (true) {
                //由左向右找出一个键值大于 pivot 者
                while (lf < right && data[++lf] <= pivot);
                //由右向左找出一个键值小于 pivot 者
                while (rg > left && data[--rg] >= pivot) ;
                //若 i<j，则 d[i] 和 d[j] 互换，继续排序，否则，跳出排序
                if (lf < rg) {
                    swap(data, lf, rg);
                } else {
                    break;
                }
            }
            //若 i 大于等于 j，//则将 d[start] 和 d[j] 互换
            swap(data, left, rg);
            showData(data,"结果");
            //并以 j 为基准点分成左右两半
            subSort(data, left, rg - 1);
            subSort(data, rg + 1, right);
        }
    }

    private void showData(int[] data,String message) {
        System.out.print("[第 " + (process) + " 趟处理"+ message +"]=> ");
        for (int datum : data) {
            System.out.print("[" + datum + "] ");
        }
        System.out.print("\n");
    }

    public void quickSort(int[] data) {
        subSort(data, 0, data.length - 1);
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] data = {49,38,65,97,76,13,27,49};
        System.out.println("排序之前: \n" + java.util.Arrays.toString(data));
        quickSort.quickSort(data);
        System.out.println("排序之后: \n" + java.util.Arrays.toString(data));
        /**
         * 输出：
         * 排序之前:
         * [49, 38, 65, 97, 76, 13, 27, 49]
         * [基准值] => 49,[排序数组索引范围] => 0-7
         * [第 1 趟处理数组]=> [49] [38] [65] [97] [76] [13] [27] [49]
         * [第 1 趟处理结果]=> [13] [38] [27] [49] [76] [97] [65] [49]
         * [基准值] => 13,[排序数组索引范围] => 0-2
         * [第 2 趟处理数组]=> [13] [38] [27] [49] [76] [97] [65] [49]
         * [第 2 趟处理结果]=> [13] [38] [27] [49] [76] [97] [65] [49]
         * [基准值] => 38,[排序数组索引范围] => 1-2
         * [第 3 趟处理数组]=> [13] [38] [27] [49] [76] [97] [65] [49]
         * [第 3 趟处理结果]=> [13] [27] [38] [49] [76] [97] [65] [49]
         * [基准值] => 76,[排序数组索引范围] => 4-7
         * [第 4 趟处理数组]=> [13] [27] [38] [49] [76] [97] [65] [49]
         * [第 4 趟处理结果]=> [13] [27] [38] [49] [65] [49] [76] [97]
         * [基准值] => 65,[排序数组索引范围] => 4-5
         * [第 5 趟处理数组]=> [13] [27] [38] [49] [65] [49] [76] [97]
         * [第 5 趟处理结果]=> [13] [27] [38] [49] [49] [65] [76] [97]
         * 排序之后:
         * [13, 27, 38, 49, 49, 65, 76, 97]
         */
    }
}
// end::code[]

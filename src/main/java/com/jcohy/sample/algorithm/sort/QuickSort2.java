package com.jcohy.sample.algorithm.sort;
// =============== Program Description ===============
// 程序名称:  CH08_06.java
// 程序目的: 快速排序法
// ===================================================

import java.util.Random;

/**
 * @author PC
 */
// tag::code[]
public class QuickSort2 extends Object {
    int process = 0;
    int size;
    int data[] = new int[100];

    public static void main(String args[]) {
        QuickSort2 quickSort = new QuickSort2();

//		System.out.print("请输入数组大小(100以下): ");
//		try{
//			InputStreamReader isr = new InputStreamReader(System.in);
//			BufferedReader br = new BufferedReader(isr);
//			test.size=Integer.parseInt(br.readLine());
//		}catch(Exception e){}

//		test.inputarr ();
//		System.out.print("原始数据是: ");
//		test.showdata ();
        int[] datas = {49,38,65,97,76,13,27,49};
        System.out.println("排序之前: \n" + java.util.Arrays.toString(datas));
        quickSort.quick(datas, datas.length, 0, datas.length - 1);
//		System.out.print("\n排序结果: ");
        System.out.println("排序之后: \n" + java.util.Arrays.toString(datas));
//		test.showdata();
    }

    void inputarr() {
        ///以随机数输入
        Random rand = new Random();
        int i;
        for (i = 0; i < size; i++) {
            data[i] = (Math.abs(rand.nextInt(99))) + 1;
        }
    }

    void showData() {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }

    void quick(int[] d, int size, int left, int right) {
        int i, j, tmp;
        int lf_idx;
        int rg_idx;

        //1:第一个键值为 d[left]
        if (left < right) {
            lf_idx = left + 1;
            rg_idx = right;

            //排序
            while (true) {
                showData();

                //2:由左向右找出一个键值大于d[lf]者
                for (i = left + 1; i <= right; i++) {
                    if (d[i] >= d[left]) {
                        lf_idx = i;
                        break;
                    }
                    lf_idx++;
                }

                //3:由右向左找出一个键值小于d[lf]者
                for (j = right; j >= left + 1; j--) {
                    if (d[j] <= d[left]) {
                        rg_idx = j;
                        break;
                    }
                    rg_idx--;
                }

                //4-1:若lf_idx<rg_idx
                if (lf_idx < rg_idx) {
                    tmp = d[lf_idx];
                    //则d[lf_idx]和d[rg_idx]互换
                    d[lf_idx] = d[rg_idx];
                    //然后继续排序
                    d[rg_idx] = tmp;
                } else {
                    break;               //否则跳出排序过程
                }
            }

            //整理
            //5-1:若lf_idx大于等于rg_idx
            if (lf_idx >= rg_idx) {
                //则将d[lf]和d[rg_idx]互换
                tmp = d[left];
                d[left] = d[rg_idx];
                d[rg_idx] = tmp;
                //5-2:并以rg_idx为基准点分成左右两半
                //以递归方式分别为左右两半进行排序
                quick(d, size, left, rg_idx - 1);
                //直至完成排序
                quick(d, size, rg_idx + 1, right);
            }
        }
    }
}
// end::code[]

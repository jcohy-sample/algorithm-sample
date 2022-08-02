// tag::code[]
package main

import (
	"fmt"
	"strconv"
)

//快速排序
//说明
//1. left 表示 数组左边的下标
//2. right 表示数组右边的下标
//3  array 表示要排序的数组

var process1 = 0

func QuickSort2(left int, right int, array *[8]int) {
	l := left
	r := right
	// pivot 是中轴， 支点
	pivot := array[(left+right)/2]

	// print
	process1++
	fmt.Println("[基准值] =>", pivot, ",[排序数组索引范围] => ", strconv.Itoa(left)+"-"+strconv.Itoa(right))
	fmt.Println("[第 ", strconv.Itoa((process1)), " 趟处理数组]=> ", *array)
	temp := 0
	// for 循环的目标是将比 pivot 小的数放到 左边
	//  比 pivot 大的数放到 右边
	for l < r {
		//从  pivot 的左边找到大于等于 pivot 的值
		for array[l] < pivot {
			l++
		}
		//从  pivot 的右边边找到小于等于 pivot 的值
		for array[r] > pivot {
			r--
		}
		// 1 >= r 表明本次分解任务完成, break
		if l >= r {
			break
		}
		//交换
		temp = array[l]
		array[l] = array[r]
		array[r] = temp
		//优化
		if array[l] == pivot {
			r--
		}
		if array[r] == pivot {
			l++
		}
	}
	// 如果  1== r, 再移动下
	if l == r {
		l++
		r--
	}
	fmt.Println("[第 ", strconv.Itoa((process1)), " 趟处理结果]=> ", *array)
	// 向左递归
	if left < r {
		QuickSort2(left, r, array)
	}
	// 向右递归
	if right > l {
		QuickSort2(l, right, array)
	}
}

func main() {
	arr := [8]int{49, 38, 65, 97, 76, 13, 27, 49}
	fmt.Println("排序之前: \n", arr)
	//调用快速排序
	QuickSort2(0, len(arr)-1, &arr)
	fmt.Println("排序之后: \n", arr)
	// 排序之前:
	//  [49 38 65 97 76 13 27 49]
	// [基准值] => 97 ,[排序数组索引范围] =>  0-7
	// [第  1  趟处理数组]=>  [49 38 65 97 76 13 27 49]
	// [第  1  趟处理结果]=>  [49 38 65 49 76 13 27 97]
	// [基准值] => 49 ,[排序数组索引范围] =>  0-6
	// [第  2  趟处理数组]=>  [49 38 65 49 76 13 27 97]
	// [第  2  趟处理结果]=>  [27 38 13 49 76 49 65 97]
	// [基准值] => 38 ,[排序数组索引范围] =>  0-2
	// [第  3  趟处理数组]=>  [27 38 13 49 76 49 65 97]
	// [第  3  趟处理结果]=>  [27 13 38 49 76 49 65 97]
	// [基准值] => 27 ,[排序数组索引范围] =>  0-1
	// [第  4  趟处理数组]=>  [27 13 38 49 76 49 65 97]
	// [第  4  趟处理结果]=>  [13 27 38 49 76 49 65 97]
	// [基准值] => 49 ,[排序数组索引范围] =>  4-6
	// [第  5  趟处理数组]=>  [13 27 38 49 76 49 65 97]
	// [第  5  趟处理结果]=>  [13 27 38 49 49 76 65 97]
	// [基准值] => 76 ,[排序数组索引范围] =>  5-6
	// [第  6  趟处理数组]=>  [13 27 38 49 49 76 65 97]
	// [第  6  趟处理结果]=>  [13 27 38 49 49 65 76 97]
	// 排序之后:
	//  [13 27 38 49 49 65 76 97]
}

// end::code[]

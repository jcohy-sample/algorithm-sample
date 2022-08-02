// tag::code[]
package main

import (
	"fmt"
)

func InsertSort(arr *[9]int) {

	//完成第一次，给第二个元素找到合适的位置并插入

	for i := 1; i < len(arr); i++ {

		insertVal := arr[i]
		insertIndex := i - 1 // 下标

		//从大到小
		for insertIndex >= 0 && arr[insertIndex] < insertVal {
			arr[insertIndex+1] = arr[insertIndex] // 数据后移
			insertIndex--
		}
		//插入
		if insertIndex+1 != i {
			arr[insertIndex+1] = insertVal
		}
		fmt.Printf("第%d次插入后 %v\n", i, *arr)
	}
}

func main() {
	arr := [9]int{9, -16, 21, 23, -30, -49, 21, 30, 30}
	fmt.Println("排序之前： \n", arr)
	InsertSort(&arr)
	fmt.Println("排序之后: \n", arr)
	// 排序之前：
	//  [9 -16 21 23 -30 -49 21 30 30]
	// 第1次插入后 [9 -16 21 23 -30 -49 21 30 30]
	// 第2次插入后 [21 9 -16 23 -30 -49 21 30 30]
	// 第3次插入后 [23 21 9 -16 -30 -49 21 30 30]
	// 第4次插入后 [23 21 9 -16 -30 -49 21 30 30]
	// 第5次插入后 [23 21 9 -16 -30 -49 21 30 30]
	// 第6次插入后 [23 21 21 9 -16 -30 -49 30 30]
	// 第7次插入后 [30 23 21 21 9 -16 -30 -49 30]
	// 第8次插入后 [30 30 23 21 21 9 -16 -30 -49]
	// 排序之后:
	//  [30 30 23 21 21 9 -16 -30 -49]
}

// end::code[]

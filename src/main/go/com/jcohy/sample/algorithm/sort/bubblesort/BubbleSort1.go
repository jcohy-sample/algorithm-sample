package main

import "fmt"

func BubbleSort(arr *[]int) *[]int {
	fmt.Println("开始排序")
	var count = 0
	for i := 0; i < len(*arr)-1; i++ {
		for j := 0; j < (len(*arr) - 1 - i); j++ {
			if (*arr)[j] > (*arr)[j+1] {
				temp := (*arr)[j]
				(*arr)[j] = (*arr)[j+1]
				(*arr)[j+1] = temp
			}
		}
		count++
		fmt.Println(*arr)
	}
	fmt.Println("排序趟数: ", count)
	return arr
}

func main() {
	arr := []int{9, -16, 21, 23, -30, -49, 21, 30, 30}
	fmt.Println("排序之前: \n", arr)
	newArr := BubbleSort(&arr)
	fmt.Println("排序之后: \n", *newArr)
	/**
	排序之前:
	 [9 -16 21 23 -30 -49 21 30 30]
	开始排序
	[-16 9 21 -30 -49 21 23 30 30]
	[-16 9 -30 -49 21 21 23 30 30]
	[-16 -30 -49 9 21 21 23 30 30]
	[-30 -49 -16 9 21 21 23 30 30]
	[-49 -30 -16 9 21 21 23 30 30]
	[-49 -30 -16 9 21 21 23 30 30]
	[-49 -30 -16 9 21 21 23 30 30]
	[-49 -30 -16 9 21 21 23 30 30]
	排序趟数:  8
	排序之后:
	 [-49 -30 -16 9 21 21 23 30 30]
	*/
}

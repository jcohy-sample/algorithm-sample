package main

import "fmt"

func BubbleSort(arr *[5]int) {
	fmt.Println("排序前 arr=", *arr)
	for i := 0; i < len(*arr); i++ {
		for j := 0; j < (len(*arr) - 1 - i); j++ {
			if (*arr)[j] > (*arr)[j+1] {
				temp := (*arr)[j]
				(*arr)[j] = (*arr)[j+1]
				(*arr)[j+1] = temp
			}
		}
	}
	fmt.Println("排序后 arr=", *arr)
}

func main() {
	arr := [5]int{2, 32, 12, 34, 55}
	BubbleSort(&arr)
	fmt.Println("main arr=", arr)
	//	输出
	//	排序前 arr= [2 32 12 34 55]
	//	排序后 arr= [2 12 32 34 55]
	//	main arr= [2 12 32 34 55]
}

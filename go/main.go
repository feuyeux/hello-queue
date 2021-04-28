package main

import (
	"fmt"
	"github.com/feuyeux/hello-queue/median"
)

func main() {
	//queue.Queue()

	fmt.Printf("output[4.5]=%3.1f\n", median.Solute([]int{1, 2, 3, 4}, []int{5, 6, 7, 8}))
	fmt.Printf("output[4.5]=%3.1f\n", median.Solute([]int{1, 3, 5, 7}, []int{2, 4, 6, 8}))
	fmt.Printf("output[3.0]=%3.1f\n", median.Solute([]int{1, 2, 3, 4}, []int{4}))
	fmt.Printf("output[2.5]=%3.1f\n", median.Solute([]int{}, []int{1, 2, 3, 4}))
	fmt.Printf("output[0]=%3.1f\n", median.Solute([]int{0, 0, 0, 0, 0}, []int{-1, 0, 0, 0, 0, 0, 1, 2}))
	fmt.Printf("output[2.5]=%3.1f\n", median.Solute([]int{}, []int{2, 3}))
	fmt.Printf("output[2]=%3.1f\n", median.Solute([]int{}, []int{2}))
	fmt.Printf("output[1]=%3.1f\n", median.Solute([]int{1, 1}, []int{1, 2}))
}

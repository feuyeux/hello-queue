package main

import (
	"fmt"
	"strconv"

	"github.com/feuyeux/hello-queue/median"
)

func main() {
	//queue.Queue()
    n :=int32(439)
	m := binaryNumbers(int(n))
	fmt.Println(m)

	fmt.Printf("output[4.5]=%3.1f\n", median.Solute([]int{1, 2, 3, 4}, []int{5, 6, 7, 8}))
	fmt.Printf("output[4.5]=%3.1f\n", median.Solute([]int{1, 3, 5, 7}, []int{2, 4, 6, 8}))
	fmt.Printf("output[3.0]=%3.1f\n", median.Solute([]int{1, 2, 3, 4}, []int{4}))
	fmt.Printf("output[2.5]=%3.1f\n", median.Solute([]int{}, []int{1, 2, 3, 4}))
	fmt.Printf("output[0]=%3.1f\n", median.Solute([]int{0, 0, 0, 0, 0}, []int{-1, 0, 0, 0, 0, 0, 1, 2}))
	fmt.Printf("output[2.5]=%3.1f\n", median.Solute([]int{}, []int{2, 3}))
	fmt.Printf("output[2]=%3.1f\n", median.Solute([]int{}, []int{2}))
	fmt.Printf("output[1]=%3.1f\n", median.Solute([]int{1, 1}, []int{1, 2}))
}

func binaryNumbers(n int) int {
	m := 0
	s := ""
	for ; n > 0; n /= 2 {
		s = strconv.Itoa(n%2) + s
	}
	for i := 0; i < len(s); i++ {
		x := fmt.Sprintf("%c", s[i])
		if x == "1" {
			m += 1
		} else {
			break
		}
	}
	return m
}

package main

import (
	"fmt"
	"math/rand"
	"time"

	"github.com/feuyeux/hello-queue/q"
	"github.com/mpvl/unique"
)

const (
	min = 1
	max = 20
)

func main() {
	q.Queue()
	ch := make(chan []int)
	flag := make(chan bool)
	ticker := time.NewTicker(5 * time.Second)
	go produce(ticker, flag, ch)
	go consume(ch)
	ending(ticker, flag, ch)
}
func produce(ticker *time.Ticker, flag chan bool, ch chan []int) {
	for {
		select {
		case <-flag:
			return
		case _ = <-ticker.C:
			list := make([]int, 10)
			for i := 0; i < 10; i++ {
				list[i] = randomOne()
			}
			ch <- list
		}
	}
}
func consume(ch chan []int) {
	for list := range ch {
		fmt.Println("received:\n", list)
		unique.Sort(unique.IntSlice{P: &list})
		fmt.Println("handled:\n", list[:5])
	}
	fmt.Println("ch closed.")
}
func randomOne() int {
	return rand.Intn((max-min)+1) + min
}
func ending(ticker *time.Ticker, flag chan bool, ch chan []int) {
	time.Sleep(10 * time.Second)
	ticker.Stop()
	flag <- true
	close(ch)
	time.Sleep(3 * time.Second)
}

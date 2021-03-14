package median

import "fmt"

func Solute(nums1 []int, nums2 []int) float64 {
	return findMedianSortedArrays(nums1, nums2)
}

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	total := len(nums1) + len(nums2)
	middle := float64(total)/2 + 0.5
	var start1, start2 int = 0, 0
	var leftMid, rightMid int = 0, 0
	var i float64 = 0
	for i < middle {
		leftMid = rightMid
		if start1 >= len(nums1) {
			rightMid = nums2[start2]
			fmt.Printf("mid_%1.0f|A2[%d]=%d\t", i, start2, rightMid)
			start2++
		} else if start2 >= len(nums2) {
			rightMid = nums1[start1]
			fmt.Printf("mid_%1.0f|A1[%d]=%d\t", i, start1, rightMid)
			start1++
		} else if nums1[start1] < nums2[start2] {
			rightMid = nums1[start1]
			fmt.Printf("mid_%1.0f=A1[%d]=%d\t", i, start1, rightMid)
			start1++
		} else {
			rightMid = nums2[start2]
			fmt.Printf("mid_%1.0f=A2[%d]=%d\t", i, start2, rightMid)
			start2++
		}
		i++
	}
	fmt.Printf("i=%1.0f,m=%3.1f\t", i, middle)
	if i == middle {
		return float64(rightMid)
	} else {
		return float64(leftMid+rightMid) / 2
	}
}

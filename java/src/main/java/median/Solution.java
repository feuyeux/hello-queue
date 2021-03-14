package median;

/**
 * Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 * <p>
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 * <p>
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 * <p>
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        double middle = (total) / 2d + 0.5;
        int start1 = 0, start2 = 0;
        int leftMid = 0, rightMid = 0;
        double i = 0;
        while (i < middle) {
            leftMid = rightMid;
            if (start1 >= nums1.length) {
                rightMid = nums2[start2++];
            } else if (start2 >= nums2.length) {
                rightMid = nums1[start1++];
            } else if (nums1[start1] < nums2[start2]) {
                rightMid = nums1[start1++];
            } else {
                rightMid = nums2[start2++];
            }
            i++;
        }
        if (i == middle) {
            return rightMid;
        } else {
            return (leftMid + rightMid) / 2d;
        }
    }
}
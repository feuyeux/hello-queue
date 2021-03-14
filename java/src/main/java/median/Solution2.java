package median;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = addAll(nums1, nums2);
        List<Integer> l3 = Arrays.stream(all).sorted().boxed().collect(Collectors.toList());
        /*l3.forEach(x -> {
            System.out.print(x + " ");
        });*/
        int len = l3.size();
        if (len % 2 == 1) {
            return l3.get(len / 2);
        } else {
            int i1 = l3.get(len / 2 - 1);
            int i2 = l3.get(len / 2);
            return (i1 + i2) / 2d;
        }
    }

    public int[] addAll(final int[] array1, final int... array2) {
        final int[] joinedArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, joinedArray, 0, array1.length);
        System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
        return joinedArray;
    }
}
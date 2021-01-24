/**
 * @author GuJun
 * @date 2021/1/23
 */
public class MiscTest {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            // 1,2,3
            return findKth(nums1, nums2, 0, 0, n/2+1);
        }
        // 1,2,3,4 n=4
        return (findKth(nums1, nums2, 0, 0, n/2) + findKth(nums1, nums2, 0, 0, n/2+1)) / 2.0;
    }

    // 两个有序数组第K小（K从1开始）
    public int findKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        // 起始索引超过数组长度的情况
        if (start1 >= nums1.length) return nums2[start2+k-1];
        if (start2 >= nums2.length) return nums1[start1+k-1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        // 如下的写法没有考虑 start + k/2 -1 越界的情况
        // if (nums1[start1 + k/2 -1] <= nums2[start2 + k/2 -1]) {
        //     return findKth(nums1, nums2, start1+k/2, start2, k-k/2);
        // } else {
        //     return findKth(nums1, nums2, start1, start2+k/2, k-k/2);
        // }

        // 若某个数组 start + k/2 -1 越界，则应该淘汰另一个数组前 start + K/2 -1 数字
        int mid1 = start1 + k/2 - 1 < nums1.length ? nums1[start1+k/2-1] : Integer.MAX_VALUE;
        int mid2 = start2 + k/2 - 1 < nums2.length ? nums2[start2+k/2-1] : Integer.MAX_VALUE;
        if (mid1 <= mid2) {
            return findKth(nums1, nums2, start1+k/2, start2, k-k/2);
        } else {
            return findKth(nums1, nums2, start1, start2+k/2, k-k/2);
        }
    }
}

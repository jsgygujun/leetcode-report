package com.jsgygujun.code.problem._00001_00100._00004_寻找两个正序数组的中位数;

import org.junit.Test;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组「nums1」和「nums2」。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *
 * @Author GuJun
 * @Date 2020/12/25
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        for (int p1 = 0, p2 = 0, n = 0; n < len1+len2 ; ++n) {
            int n1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int n2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            if (n1 <= n2) {
                nums[n] = n1;
                ++p1;
            } else {
                nums[n] = n2;
                ++p2;
            }
        }
        return (len1 + len2) % 2 == 1 ? nums[(len1+len2)/2] : 0.5*(nums[(len1+len2)/2 -1] + nums[(len1+len2)/2]);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // (len1+len2) % 2 == 1: 中位数 nums[(len1+len2)/2]
        // (len1+len2) % 2 == 0: 中位数(nums[(len1+len2)/2-1] + nums[(len1+len2)/2]) * 0.5
        int mid = (len1+len2) / 2;
        int n = 0;
        int val1 = 0;
        int val2 = 0;
        for (int p1 = 0, p2 = 0; n <= mid; ++n) {
            int n1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int n2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            val1 = val2;
            if (n1 <= n2) {
                val2 = n1;
                ++p1;
            } else {
                val2 = n2;
                ++p2;
            }
        }
        return (len1 + len2) % 2 == 1 ? val2 : 0.5*(val1 + val2);
    }

    @Test
    public void test_1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    public void test_2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    public void test_3() {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    public void test_4() {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
    }

}

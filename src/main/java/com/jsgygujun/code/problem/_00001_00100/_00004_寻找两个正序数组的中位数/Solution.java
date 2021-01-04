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

    // 分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用
    // 首先定义一个函数来在两个有序数组中找到第K个元素，下面重点来看如何实现找到第K个元素。
    // 首先，为了避免产生新的数组从而增加时间复杂度，使用两个变量i和j分别来标记数组nums1和nums2的起始位置。
    // 然后来处理一些边界问题，比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。
    // 还有就是如果K=1的话，那么我们只要比较nums1和nums2的起始位置i和j上的数字就可以了。
    // 难点就在于一般的情况怎么处理？因为我们需要在两个有序数组中找到第K个元素，为了加快搜索的速度，我们要使用二分法，
    // 对K二分，意思是我们需要分别在nums1和nums2中查找第K/2个元素，注意这里由于两个数组的长度不定，所以有可能某个数组没有第K/2个数字，
    // 所以我们需要先检查一下，数组中到底存不存在第K/2个数字，如果存在就取出来，否则就赋值上一个整型最大值。如果某个数组没有第K/2个数字，那么我们就淘汰另一个数字的前K/2个数字即可。
    // 有没有可能两个数组都不存在第K/2个数字呢，这道题里是不可能的，因为我们的K不是任意给的，而是给的m+n的中间值，所以必定至少会有一个数组是存在第K/2个数字的。
    // 最后就是二分法的核心，比较这两个数组的第K/2小的数字midVal1和midVal2的大小，如果第一个数组的第K/2个数字小的话，那么说明我们要找的数字肯定不在nums1中的前K/2个数字，所以我们可以将其淘汰，
    // 将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。反之，淘汰nums2中的前K/2个数字，并将nums2的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归即可。
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1+len2+1)/2;
        int right = (len1+len2+2)/2;
        return 0.5 * (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right));
    }

    /**
     * 寻找两个「有序」数组的「第K小」的元素
     *
     * @param nums1 数组1
     * @param i 从数组1的i下标元素开始
     * @param nums2 数组二
     * @param j 从数组2的j下标元素开始
     * @param k 第K小元素，K 从 1 开始
     * @return
     */
    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 1. 起始索引超过数组大小的情况
        if (i >= nums1.length) return nums2[j+k-1]; // nums1 为空数组
        if (j >= nums2.length) return nums1[i+k-1]; // nums2 为空数组
        // 2. k == 1 的情况
        if (k == 1) return Math.min(nums1[i], nums2[j]); // k == 1 的情况，返回nums1[i], nums2[j]的较小者
        // 3. 分别考虑两个数组第「k/2」小元素的情况，哪个小，就淘汰谁（说明第「K」小元素肯定不在那个数组的前「k/2」个元素中）
        // 淘汰谁即将起始索引向后移动k/2个数组，并且k也要减去k/2
        int mid1 = (i+k/2-1 < nums1.length) ? nums1[i+k/2-1] : Integer.MAX_VALUE; // 赋予最大值的意思只是说如果第一个数组的K/2不存在，则说明这个数组的长度小于K/2，那么另外一个数组的前K/2个我们是肯定不要的
        int mid2 = (j+k/2-1 < nums2.length) ? nums2[j+k/2-1] : Integer.MAX_VALUE;
        return mid1 <= mid2 ? findKth(nums1, i+k/2, nums2, j, k-k/2) : findKth(nums1, i, nums2, j+k/2, k-k/2);
    }

    @Test
    public void test_1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays3(nums1, nums2));
    }

    @Test
    public void test_2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays3(nums1, nums2));
    }

    @Test
    public void test_3() {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays3(nums1, nums2));
    }

    @Test
    public void test_4() {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays3(nums1, nums2));
    }

}

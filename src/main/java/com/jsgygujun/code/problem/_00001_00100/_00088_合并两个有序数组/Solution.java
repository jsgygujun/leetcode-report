package com.jsgygujun.code.problem._00001_00100._00088_合并两个有序数组;

import org.junit.Test;

/**
 * 88. 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m+n-1, p1 = m-1, p2 = n-1; i >= 0; --i) {
            int val1 = p1 >= 0 ? nums1[p1] : Integer.MIN_VALUE;
            int val2 = p2 >= 0 ? nums2[p2] : Integer.MIN_VALUE;
            if (val1 >= val2) {
                nums1[i] = val1;
                p1--;
            } else {
                nums1[i] = val2;
                p2--;
            }
        }
    }
}

package com.jsgygujun.code.排序算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author GuJun
 * @date 2020/12/12
 */
public class 归并排序 {

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length);
    }

    // 对区间[l,r)进行归并排序
    public void mergeSort(int[] nums, int l, int r) {
        if (r-l > 1) { // 排序空间长度「>1」才有分治的必要
            int m = l + (r-l)/2;
            mergeSort(nums, l, m);
            mergeSort(nums, m, r);
            merge(nums, l, m, r);
        }
    }

    // 合并左右两个有序数组 L:[l,m), R:[m.r)
    private void merge(int[] nums, int l, int m, int r) {
        int len1 = m-l, len2 = r-m;
        int[] L = new int[len1]; // 有序数组L
        int[] R = new int[len2]; // 有序数组R
        // 拷贝
        System.arraycopy(nums, l, L, 0, len1);
        System.arraycopy(nums, m, R, 0, len2);
        int curr = l, p1 = 0, p2 = 0;
        while (p1 < len1 || p2 < len2) {
            int v1 = p1 < len1 ? L[p1] : Integer.MAX_VALUE;
            int v2 = p2 < len2 ? R[p2] : Integer.MAX_VALUE;
            if (v1 <= v2) {
                nums[curr] = v1;
                p1++;
            } else {
                nums[curr] = v2;
                p2++;
            }
            curr++;
        }
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{1,3,2,4,5,9,7,6};
        new 归并排序().mergeSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

}

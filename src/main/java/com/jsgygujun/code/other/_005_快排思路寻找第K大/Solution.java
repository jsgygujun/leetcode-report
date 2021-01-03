package com.jsgygujun.code.other._005_快排思路寻找第K大;

import org.junit.Test;

/**
 * @author GuJun
 * @date 2021/1/3
 */
public class Solution {

    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n-1, K);
    }

    public int findKth(int[] nums, int l, int r, int K) {
        if (l <= r) {
            int pivot = partition(nums, l, r);
            if (pivot == K-1) return nums[pivot];
            if (pivot < K-1) return findKth(nums, pivot+1, r, K); // 查找右边
            return findKth(nums, l, pivot-1, K); // 查找左边
        }
        return -1;
    }

    // Partition 算法
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= pivot) r--;
            if (l < r) {
                nums[l] = nums[r];
            }
            while (l < r && nums[l] >= pivot) l++;
            if (l < r) {
                nums[r] = nums[l];
            }
        }
        nums[l] = pivot;
        return l;
    }

    @Test
    public void test() {
        System.out.println(new Solution().findKth(new int[]{1,3,5,2,2}, 5, 3));
    }
}

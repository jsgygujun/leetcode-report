package com.jsgygujun.code.template.binary_search;

/**
 * @author GuJun
 * @date 2020/12/12
 */
public class BinarySearch {
    // 二分查找，左闭右开区间
    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length; // 搜索空间：[l, r)
        while (l < r) { // 搜索条件：搜索空间不为空
            int m = l + (r-l)/2;
            if (nums[m] == target) return m;
            // 此时「m」将搜索空间分成了[l,m) (m,r) 也即： [l,m) [m+1,r)
            else if (nums[m] < target) l = m+1;
            else r = m;
        }
        return -1;
    }
}

package com.jsgygujun.code.problem._00001_00100._00033_搜索旋转排序数组;

import org.junit.Test;

/**
 * 33. 搜索旋转排序数组
 *
 * 题目：
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转(例如， [0,1,2,4,5,6,7] 经旋转后可能变为[4,5,6,7,0,1,2] )。
 *
 * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 * @Author GuJun
 * @Date 2020/12/30
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (nums[mid] == target) return mid;
            // 判断左边有序还是右边有序[l, m), m, [m+1, r)
            if (nums[l] < nums[mid]) {
                // 左边有序
                if (target >= nums[l] && target < nums[mid]) {
                    // target 在左边
                    r = mid;
                } else {
                    // target 在右边
                    l = mid + 1;
                }
            } else {
                // 右边有序
                if (target > nums[mid] && target <= nums[r-1]) {
                    // target 在右边K
                    l = mid + 1;
                } else {
                    // target 在左边
                    r = mid;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] == target) return m;
            if ((nums[l] <= nums[m])) {
                // [l...m] 有序
                if (target >= nums[l] && target < nums[m]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else {
                // [m...r] 有序
                if (target > nums[m] && target <= nums[r]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(new Solution().search(new int[] {5,6,7,0,1,2}, 0));
    }

    @Test
    public void test2() {
        System.out.println(new Solution().search2(new int[]{3,1}, 1));
    }
}

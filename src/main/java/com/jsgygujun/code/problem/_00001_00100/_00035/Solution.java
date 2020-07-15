package com.jsgygujun.code.problem._00001_00100._00035;

import org.junit.Assert;
import org.junit.Test;

/**
 * 35. 搜索插入位置
 * 难度： 简单
 * 题目：
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例1：
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例2：
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例3：
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例4：
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Solution {
    // 搜索第一个比target不小的数
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) lo = mid+1;
            else hi = mid;
        }
        // 如果nums[lo]比target小，则nums[lo+1]一定比target大
        return lo == nums.length || nums[lo] > target ? lo : lo+1;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, new Solution().searchInsert(new int[]{1,3,5,6,}, 5));
        Assert.assertEquals(1, new Solution().searchInsert(new int[]{1,3,5,6,}, 2));
        Assert.assertEquals(4, new Solution().searchInsert(new int[]{1,3,5,6,}, 7));
        Assert.assertEquals(0, new Solution().searchInsert(new int[]{1,3,5,6,}, 0));
    }
}

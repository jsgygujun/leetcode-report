package com.jsgygujun.code.problem._00001_00100._00034;

import org.junit.Test;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 题目：
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2：
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        return new int[]{searchLeftRange(nums, target), searchRightRange(nums, target)};
    }

    public int searchLeftRange(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target) hi = mid;
            else if (nums[mid] < target) lo = mid+1;
            else hi = mid;
        }
        return lo < nums.length && nums[lo] == target ? lo : -1;
    }

    public int searchRightRange(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target) lo = mid+1;
            else if (nums[mid] < target) lo = mid+1;
            else hi = mid;
        }
        return lo > 0 && nums[lo-1] == target ? lo-1 : -1;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1,1,2}, 6)));
    }
}

package com.jsgygujun.code.problem._00001_00100._00027;

import org.junit.Test;

import java.util.Arrays;

/**
 * 27. 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例1：
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例2：
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            while (j < nums.length && nums[j] == val) ++j;
            if (j < nums.length) {
                swap(i, j, nums);
                ++i;
            }
        }
        return i;
    }

    private void swap(int i, int j, int[] nums) {
        System.out.println("i: " + i + ", j: " + j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(new Solution().removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(new Solution().removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }


}

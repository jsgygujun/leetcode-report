package com.jsgygujun.code.problem._00101_00200._00167;

import org.junit.Test;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 题目：
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return new int[]{-1, -1};
        int p = 0, q = numbers.length-1;
        while (p < q) {
            int sum = numbers[p] + numbers[q];
            if (sum == target) return new int[]{p+1, q+1};
            else if (sum < target) ++p;
            else --q;
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}

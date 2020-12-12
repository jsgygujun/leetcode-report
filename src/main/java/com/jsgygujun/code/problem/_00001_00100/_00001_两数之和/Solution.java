package com.jsgygujun.code.problem._00001_00100._00001_两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * 题目：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1. 定义一个HashMap用来记录数组nums中的值和其对应的下标；
        // 2. 遍历数组nums，判断在HashMap中是否存在Key为`target-nums[i]`，
        //    若存在则当前数组下标`i`和HashMap中`Key`为`target-nums[i]`的`Value`为答案；
        //    否则将nums和`i`分别作为`Key`和`Value`加入到HashMap中。
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = sol.twoSum(nums, target);
        System.out.println(res[0] + ", " + res[1]);
    }
}

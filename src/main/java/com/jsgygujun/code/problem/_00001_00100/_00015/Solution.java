package com.jsgygujun.code.problem._00015;

import org.junit.Test;

import java.util.*;

/**
 * 15-三数之和
 *
 * 题目：
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums[p] + nums[q] = -nums[i]
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int target = -nums[i];
            if (target > 0) break;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < nums.length; ++j) {
                if (map.containsKey(target-nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[j]);
                    list.add(nums[map.get(target-nums[j])]);
                    list.add(nums[i]);
                    ans.add(list);
                    while (j < nums.length-1 && nums[j+1] == nums[j]) ++j;
                } else {
                    map.put(nums[j], j);
                }
            }
            while (i < nums.length-1 && nums[i+1] == nums[i]) ++i;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}

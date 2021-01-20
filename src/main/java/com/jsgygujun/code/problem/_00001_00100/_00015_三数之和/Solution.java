package com.jsgygujun.code.problem._00001_00100._00015_三数之和;

import org.junit.Test;

import java.util.*;

/**
 * 15. 三数之和
 *
 * 题目：
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
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

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 && nums[i] <= 0; ++i) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int a = nums[i];
            int j = i+1, k = nums.length-1;

            while (j < k) {
                int b = nums[j], c = nums[k];
                if (a + b + c == 0) {
                    ans.add(Arrays.asList(a,b,c));
                    ++j;
                    while (j < k && nums[j] == nums[j-1]) ++j;
                    --k;
                } else if (a + b + c < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(new Solution().threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }

    @Test
    public void test2() {
        System.out.println(new Solution().threeSum2(new int[]{-2,0,0,2,2}));
    }
}

package com.jsgygujun.code._00001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
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

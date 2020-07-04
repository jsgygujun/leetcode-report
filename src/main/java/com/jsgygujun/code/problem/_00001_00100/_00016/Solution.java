package com.jsgygujun.code.problem._00016;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 20000;
        for (int i = 0; i < nums.length-2; ++i) {
            int p = i+1, q = nums.length-1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (Math.abs(sum-target) < Math.abs(ans-target)) ans = sum;
                if (sum == target) break;
                else if (sum > target) --q;
                else ++p;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{1,1,-1,-1,3}, -1));
    }
}

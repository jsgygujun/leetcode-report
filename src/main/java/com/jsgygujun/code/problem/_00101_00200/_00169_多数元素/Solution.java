package com.jsgygujun.code.problem._00101_00200._00169_多数元素;

import org.junit.Test;

/**
 * @Author GuJun
 * @Date 2021/1/2
 */
public class Solution {
    /**
     * 摩尔投票法思路
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     *
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     *
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int ans = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == ans) {
                ++cnt;
            } else {
                --cnt;
            }
            if (cnt == 0 && i < nums.length-1) {
                ans = nums[i+1];
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(new Solution().majorityElement(new int[] {3,2,3}));
    }

    @Test
    public void test2() {
        System.out.println(new Solution().majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}

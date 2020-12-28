package com.jsgygujun.code.problem._00201_00300._00217_存在重复元素;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * 题目：
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (!s.add(num)) return true;
        }
        return false;
    }

    @Test
    public void test_1() {
        Assert.assertTrue(new Solution().containsDuplicate(new int[] {1,2,3,1}));
    }
}

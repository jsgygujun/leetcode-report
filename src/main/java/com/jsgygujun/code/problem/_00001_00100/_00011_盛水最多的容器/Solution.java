package com.jsgygujun.code.problem._00001_00100._00011_盛水最多的容器;

import org.junit.Assert;
import org.junit.Test;

/**
 * 11-盛水最多的容器
 *
 * 题目：
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为(i,ai) 和 (i, 0)。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且n的值至少为 2。
 *
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class Solution {
    // 双指针
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int ans = Integer.MIN_VALUE;
        while (i < j) {
            ans = Math.max(ans, (j-i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(49, new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

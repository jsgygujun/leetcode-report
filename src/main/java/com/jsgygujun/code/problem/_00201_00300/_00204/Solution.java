package com.jsgygujun.code.problem._00201_00300._00204;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例：
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean nums[] = new boolean[n];
        Arrays.fill(nums, true);
        nums[0] = nums[1] = false;
        int minPrime = 2;
        while (true) {
            for (int i = 2; i * minPrime < n ; ++i) {
                nums[i*minPrime] = false;
                //System.out.println("i:" + i + ", minPrime:" + minPrime);
            }
            minPrime = searchMinPrime(nums, minPrime+1);
            if (minPrime == -1) break;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i]) ans += 1;
        }
        return ans;
    }

    int searchMinPrime(boolean[] nums, int start) {
        for (int i = start; i < nums.length; ++i) {
            if (nums[i]) return i;
        }
        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, new Solution().countPrimes(10));
    }
    @Test
    public void test2() {
        System.out.println(new Solution().countPrimes(499979));
    }

}

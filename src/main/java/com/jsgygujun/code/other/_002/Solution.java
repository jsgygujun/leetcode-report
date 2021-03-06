package com.jsgygujun.code.other._002;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 面试题 16.11. 跳水板
 *
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 *
 * 提示
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 */
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i <= k; ++i) {
            set.add(shorter*i + (k-i)*longer);
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for (int n : set) {
            ans[i++] = n;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(new Solution().divingBoard(1, 2, 3)));
    }
}

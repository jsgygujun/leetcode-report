package com.jsgygujun.code.problem._00001_00100._00089_格雷编码;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class Solution {
    /**
     * 0     1      2       3
     *
     * 0     0     00     000
     *       1     01     001
     *             11     011
     *             10     010
     *                    110
     *                    111
     *                    101
     *                    100
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int one = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = ans.size()-1; j >= 0; --j) { // 镜像
                ans.add(one + ans.get(j));
            }
            one <<= 1;
        }
        return ans;
    }
}

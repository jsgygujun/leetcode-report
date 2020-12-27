package com.jsgygujun.code.problem._00201_00300._00238_除自身以外的数组的乘积;

import org.junit.Test;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * 题目：
 * 给你一个长度为「n」的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 *
 * 示例：
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @author GuJun
 * @date 2020/12/27
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; ++i) {
            prefix[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length-1; i >= 0; --i) {
            suffix[i] = product;
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }

    // 优化空间
    public int[] productExceptSelf2(int[] nums) {
        int [] ans = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length-1; i >= 0; --i) {
            ans[i] *= product;
            product *= nums[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int [] ans = new Solution().productExceptSelf(new int[] {1,2,3,4});
        for (int i = 0; i < ans.length; ++i) System.out.println(ans[i] + ", ");
        System.out.println();
        int [] ans2 = new Solution().productExceptSelf2(new int[] {1,2,3,4});
        for (int i = 0; i < ans2.length; ++i) System.out.println(ans2[i] + ", ");
        System.out.println();
    }
}

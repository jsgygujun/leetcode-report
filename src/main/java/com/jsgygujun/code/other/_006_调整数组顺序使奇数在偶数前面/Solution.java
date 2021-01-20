package com.jsgygujun.code.other._006_调整数组顺序使奇数在偶数前面;

import org.junit.Test;

/**
 * @author GuJun
 * @date 2021/1/7
 */
public class Solution {

    public void reOrderArray(int [] array) {
        int[] ans = new int[array.length];
        int pos = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                ans[pos++] = array[i];
            }
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 0) {
                ans[pos++] = array[i];
            }
        }
        array = ans;
    }

    @Test
    public void test() {
        int[] array = new int[] {1,2,3,4,5,6};
        new Solution().reOrderArray(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

}

package com.jsgygujun.code.problem._00201_00300._00215_数组中第K个最大的元素;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 215-数组中的第K个最大元素
 *
 * 题目：
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Solution {
    // 小项堆或者大项堆
    // 求解第K大或者第K小，一般思路就是构建一个只有K个节点的堆，最后返回堆顶
    // Java里面堆可以用PriorityQueue，默认是小项堆，如果要实现大项堆的话，要重写comparator。
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        return minHeap.peek();
    }

    @Test
    public void test_2() {
        Solution sol = new Solution();
        System.out.println(sol .findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}

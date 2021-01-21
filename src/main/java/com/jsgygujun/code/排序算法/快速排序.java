package com.jsgygujun.code.排序算法;

/**
 * @author GuJun
 * @date 2021/1/3
 */
public class 快速排序 {

    // 「Partition」 算法
    // 选择任意元素作为pivot， 经过Partition算法之后所有小于等于pivot的数都在左侧，所有大于等于pivot的数都在右侧，返回pivot的下标。
    static int partition(int[] nums, int l, int r) {
        int pivot = nums[l]; // 选择左边界的元素作为pivot，此时nums[l]是一个空位
        while (l < r) {
            // 从右开始
            while (l < r && (nums[r] >= pivot)) --r;
            if (l < r) {
                // 此时nums[r] < pivot，应该放在左侧空位nums[l]
                nums[l] = nums[r];
                ++l;
            }
            // 从左开始
            while (l < r && (nums[l] <= pivot)) ++l;
            if (l < r) {
                // 此时nums[l] > pivot，应该放在右侧空位nums[r]
                nums[r] = nums[l];
                --r;
            }
        }
        // 循环终止条件：l == r;
        nums[l] = pivot; // 将partition填入最后的空位
        return l;
    }

    static void quickSortCore(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            quickSortCore(nums, l, pivot - 1);
            quickSortCore(nums, pivot + 1, r);
        }
    }

    static void quickSort(int[] nums) {
        if (nums.length >= 1) quickSortCore(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,4,2,3,3,3,5,3};
        quickSort(nums);
        for (int n : nums) System.out.println(n);
    }
}

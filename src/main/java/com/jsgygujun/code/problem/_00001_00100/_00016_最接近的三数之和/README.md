# 最接近的三数之和



## 题目

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例：

```
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
```

提示：

```
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
```

## 思路

* 排序
* 遍历数组，取nums[i]
* 在[i+1, end)中取两个数，使得相加与target-nums[i]最接近（双指针法）

## 解法

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 20000;
        for (int i = 0; i < nums.length-2; ++i) {
            int p = i+1, q = nums.length-1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (Math.abs(sum-target) < Math.abs(ans-target)) ans = sum;
                if (sum == target) break;
                else if (sum > target) --q;
                else ++p;
            }
        }
        return ans;
    }
}
```




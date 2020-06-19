package com.jsgygujun.code.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        if (nums  == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can't be null nor empty!");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; ++i) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            sb.append(" -> ");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ListNode(new int[]{1, 2, 3, 4, 5, 6}));
    }
}

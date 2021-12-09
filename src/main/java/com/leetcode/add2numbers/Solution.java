package com.leetcode.add2numbers;


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建pre的原因在于标记header，便于返回listNode， 否则current node一直在更新，最后无法返回
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        // 是否进位， 值仅可能为0 | 1
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 当两个链表不一样长时，为短的链表补0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum > 9 ? 1 : 0;
            // 开始时，current即pre，而pre的意义在于占位， 因此更新next
            current.next = new ListNode(sum % 10);

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            current = current.next;
        }
        // 当计算完所有链表的值，carry为1表示仍需进位
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        // pre此时仍为0， 但pre.next则为实际的header
        return pre.next;
    }

}

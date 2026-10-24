class Solution {
    public int pairSum(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);

        int ans = 0;
        while (head2 != null) {
            ans = Math.max(ans, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }
        return ans;
    }
    // 快慢指针法找链表中点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
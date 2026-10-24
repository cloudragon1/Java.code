class Solution {
    private int ans;
    private ListNode left;

    public int pairSum(ListNode head) {
        left = head;
        dfs(head);
        return ans;
    }
    private void dfs(ListNode right) {
        if (right.next != null) {
            dfs(right.next);
        }
        ans = Math.max(ans, left.val + right.val);
        left = left.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode node, int num) {
        if (node == null){
            return;
        }

        num = num << 1 | node.val;

        if (node.left == null && node.right == null){
            ans += num;
            return;
        }
        dfs(node.left, num);
        dfs(node.right, num);
    }
}

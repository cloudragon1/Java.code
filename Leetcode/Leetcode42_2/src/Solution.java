import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            int rightH = height[i];
            while (!queue.isEmpty() && height[queue.peek()] < rightH) {
                int bottomH = height[queue.pop()];
                if (queue.isEmpty()) break;
                int leftH = height[queue.peek()];
                int h = Math.min(rightH, leftH) - bottomH;
                ans += h * (i - queue.peek() - 1);
            }
            queue.push(i);
        }
        return ans;
    }
}
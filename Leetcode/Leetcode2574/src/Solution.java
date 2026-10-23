/*
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int j = n - 1; j > i; j--) {
                right += nums[j];
            }
            ans[i] = Math.abs(left - right);
            left = 0;
            right = 0;
        }
        return ans;
    }
}*/

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = Math.abs(leftSum * 2 + x - total);
            leftSum += x;
        }
        return nums;
    }
}
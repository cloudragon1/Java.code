import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int stackSize = 0;
        for (int i : nums) {
            if (i != 0) {
                nums[stackSize++] = i;
            }
        }
        Arrays.fill(nums, stackSize, nums.length, 0);
    }
}
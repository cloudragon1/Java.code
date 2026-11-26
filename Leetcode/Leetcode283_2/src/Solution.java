class Solution {
    public void moveZeroes(int[] nums) {
        int start0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[start0];
                nums[start0] = nums[i];
                nums[i] = temp;
                start0++;
            }
        }
    }
}
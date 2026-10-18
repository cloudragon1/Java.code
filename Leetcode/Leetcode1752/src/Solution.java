class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int sorted = 0;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] < nums[i % n]){
                sorted++;
            }
        }
        return sorted > 1 ? false : true;
    }
}
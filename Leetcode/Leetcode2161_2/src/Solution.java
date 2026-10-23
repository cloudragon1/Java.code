import java.util.Arrays;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        Arrays.fill(ans, pivot);

        for (int num : nums) {
            if (num < pivot){
                ans[left++] = num;
            }else if (num > pivot) {
                ans[right--] = num;
            }
        }
        reverse(ans, right + 1, n - 1);
        return ans;
    }
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
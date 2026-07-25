class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int ans = n - 1;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            int sum = s.charAt(i) - '0' + carry;
            ans += sum % 2;
            carry = (sum + sum % 2) / 2;
        }
        return ans + carry;
    }
}
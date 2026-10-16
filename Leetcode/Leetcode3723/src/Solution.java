class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num * 9 < sum){
            return "";
        }
        StringBuilder ans = new StringBuilder(num).repeat('9', sum / 9);
        if (sum % 9 > 0) {
            ans.append((char) ('0' + sum % 9));
        }
        ans.repeat('0', num - ans.length());
        return ans.toString();
    }
}
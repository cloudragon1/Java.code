class Solution {
    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n >>= 1;
        while(n > 0){
            int cur = n & 1;
            if(cur == pre) return false;
            pre = cur;
            n >>= 1;
        }
        return true;
    }
}
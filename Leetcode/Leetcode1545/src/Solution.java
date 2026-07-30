class Solution {
    public char findKthBit(int n, int k) {
        int mid = 1 << (n - 1);
        if (n == 1){
            return '0';
        }
        if (k == mid){
            return '1';
        }
        if (k < mid){
            return findKthBit(n - 1, k);
        }
        return (char)((findKthBit(n - 1, (1 << n) - k)) ^ 1);
    }
}


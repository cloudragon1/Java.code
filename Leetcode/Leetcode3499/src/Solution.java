class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char[] S = s.toCharArray();
        int total1 = 0;
        int mx = 0;
        int pre0 = -100000;
        int count = 0;
        for (int i = 0; i < S.length; i++) {
            count++;
            if (i == S.length-1 || S[i] != S[i + 1]){
                if (S[i] == '1'){
                    total1 += count;
                }else {
                    mx = Math.max(mx, pre0 + count);
                    pre0 = count;
                }
                count = 0;
            }
        }
        return total1 + mx;
    }
}
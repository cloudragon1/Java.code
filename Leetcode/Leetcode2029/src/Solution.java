/*
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        if (cnt[0] >= 0) {
            return cnt[1] > 0 && cnt[2] > 0;
        }
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }
}*/

class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        int n = stones.length;
        return check(n, cnt.clone()) || check(n, new int[]{cnt[0], cnt[2], cnt[1]});
    }
    private boolean check(int n, int[] cnt){
        if (cnt[1] == 0) {
            return false;
        }
        cnt[1]--;
        int rounds = 1 + Math.min(cnt[1], cnt[2]) * 2 + cnt[0];
        if (cnt[1] > cnt[2]) {
            rounds++;
        }
        return rounds < n && rounds % 2 > 0;
    }
}
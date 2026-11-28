class Solution {
    public String minWindow(String S, String t) {
        int[] diff = new int[128];
        int kinds = 0;
        for (char c : t.toCharArray()) {
            if (diff[c] == 0) kinds++;
            diff[c]--;
        }
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int getCnt = 0;
        int left = 0;

        for (int right = 0; right < m; right++) {
            char c = s[right];
            diff[c]++;
            if (diff[c] == 0) {
                getCnt++;
            }

            while (getCnt == kinds) {
                if (right - left <= ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }

                char x = s[left];
                if (diff[x] == 0) {
                    getCnt--;
                }
                diff[x]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }
}
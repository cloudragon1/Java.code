/*
import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int m = n / 2;
        char[] t = s.substring(0,m).toCharArray();
        Arrays.sort(t);

        StringBuilder ans = new StringBuilder(n);
        ans.append(t);

        if (n % 2 > 0){
        ans.append(s.charAt(m));
        }
        for (int i = m - 1; i >= 0; i--) {
        ans.append(t[i]);
        }
        return ans.toString();
    }
}*/

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] cnt = new int[26];

        for (int i = 0; i < n / 2; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder ans = new StringBuilder(n);
        for (int i = 0; i < 26; i++) {
            ans.repeat('a' + i, cnt[i]);
        }

        StringBuilder t = new StringBuilder(ans);
        if (n % 2 > 0){
            ans.append(s.charAt(n / 2));
        }
        ans.append(t.reverse());
        return ans.toString();
    }
}
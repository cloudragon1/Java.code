import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String q : queries) {
            for (String s : dictionary) {
                int cnt = 0;
                for (int i = 0; i < s.length() && cnt <= 2; i++) {
                    if (q.charAt(i) != s.charAt(i)) {
                        cnt++;
                    }
                }
                if (cnt <= 2) {
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
}
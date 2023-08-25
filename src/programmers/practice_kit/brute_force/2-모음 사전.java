package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    // 굳이 static 키워드가 필요하지 않음
    final char[] ALPHAS = { 'A', 'E', 'I', 'O', 'U' };
    List<String> words = new ArrayList<>();

    public int solution(String word) {
        dfs(0, "");
        return words.indexOf(word) + 1;
    }

    private void dfs(int cnt, String w) {
        if (cnt == 5) {
            return;
        }
        for (char alpha : ALPHAS) {
            words.add(w + alpha);
            dfs(cnt + 1, w + alpha);
        }
    }
}

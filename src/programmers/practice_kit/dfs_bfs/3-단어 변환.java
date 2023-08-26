package programmers.practice_kit.dfs_bfs;

import java.util.*;

class Solution {
    Set<String> visited = new HashSet<>();
    int minStep = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        // Array는 포함여부 확인이 번거롭기 때문에 ArrayList로 변환
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        if (!wordsList.contains(target)) {
            return 0;
        }

        dfs(begin, 0, target, words);

        return (minStep == Integer.MAX_VALUE) ? 0 : minStep;
    }

    private boolean isChangeable(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    private void dfs(String cur, int step, String target, String[] words) {
        if (cur.equals(target)) {
            minStep = Math.min(minStep, step);
        }
        for (String word : words) {
            if (!visited.contains(word) && isChangeable(cur, word)) {
                visited.add(word);
                dfs(word, step + 1, target, words);
                visited.remove(word);
            }
        }
    }
}

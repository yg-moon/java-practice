package programmers.practice_kit.hash;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeCountMap = new HashMap<>();

        for (String[] cloth : clothes) {
            typeCountMap.put(cloth[1], typeCountMap.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        for (String key : typeCountMap.keySet()) {
            answer *= typeCountMap.get(key) + 1;
        }

        return answer - 1;
    }
}

package programmers.practice_kit.hash;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> nameCountMap = new HashMap<>();

        // dic[key] += 1 할때 keyError를 방지하려면 이렇게 씀
        for (String p : participant) {
            nameCountMap.put(p, nameCountMap.getOrDefault(p, 0) + 1);
        }

        // dic[key] -= 1 는 이렇게 씀
        for (String c : completion) {
            nameCountMap.put(c, nameCountMap.get(c) - 1);
        }

        for (String key : nameCountMap.keySet()) {
            if (nameCountMap.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}

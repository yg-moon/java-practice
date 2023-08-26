package programmers.practice_kit.hash;

import java.util.*;

// 자바 오리지널 버전
class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> numSet = new HashSet<>();

        for (String num : phoneBook) {
            numSet.add(num);
        }

        // 모든 전화번호의 substring이 set에 존재하는지 확인
        for (String num : phoneBook) {
            for (int i = 0; i < num.length(); i++) {
                if (numSet.contains(num.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}

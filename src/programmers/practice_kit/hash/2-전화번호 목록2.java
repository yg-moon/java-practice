package programmers.practice_kit.hash;

import java.util.*;

// 자바 오리지널 버전
class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>();

        // 모든 전화번호를 set에 넣음
        for (int i = 0; i < phoneBook.length; i++)
            set.add(phoneBook[i]);

        // 모든 전화번호의 substring이 set에 존재하는지 확인
        for (int i = 0; i < phoneBook.length; i++)
            for (int j = 0; j < phoneBook[i].length(); j++)
                if (set.contains(phoneBook[i].substring(0, j)))
                    return false;

        return true;
    }
}
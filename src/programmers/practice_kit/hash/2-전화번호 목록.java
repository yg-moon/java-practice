package programmers.practice_kit.hash;

import java.util.*;

// 파이썬 변환 버전
class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> numSet = new HashSet<>();

        for (String num : phoneBook) {
            numSet.add(num);
        }

        for (String num : phoneBook) {
            String temp = "";
            // 문자열의 각 글자에 하나씩 접근하려면 char 배열로 변환
            for (char n : num.toCharArray()) {
                temp += n;
                if (numSet.contains(temp) && !temp.equals(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}

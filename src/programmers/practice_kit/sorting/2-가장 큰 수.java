package programmers.practice_kit.sorting;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 비교기준 간단설정
        Arrays.sort(strNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 예외처리
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // "".join() 동작은 이렇게 씀
        StringBuilder answer = new StringBuilder();
        for (String num : strNumbers) {
            answer.append(num);
        }
        return answer.toString();
    }
}

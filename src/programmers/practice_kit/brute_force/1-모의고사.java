package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        final int[] person1 = { 1, 2, 3, 4, 5 };
        final int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        final int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        // 가능하면 함수를 작성하는 대신 배열에 결과를 저장해서 해결
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) {
                scores[0]++;
            }
            if (answers[i] == person2[i % person2.length]) {
                scores[1]++;
            }
            if (answers[i] == person3[i % person3.length]) {
                scores[2]++;
            }
        }

        // 배열의 최댓값 간단히 구하는 방법 (스트림)
        int maxScore = Arrays.stream(scores).max().getAsInt();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                answerList.add(i + 1);
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}

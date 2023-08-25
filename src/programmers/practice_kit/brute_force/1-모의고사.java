package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자들 찍는 패턴에 따른 배열 만들기
        final int[] person1 = { 1, 2, 3, 4, 5 };
        final int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        final int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        // % 연산자를 이용해서 각 수포자가 몇 개 맞췄는지 계산
        // 자바: 가능하면 함수를 작성하는 대신 배열에 결과를 저장해서 해결
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

        // 최고점인 사람들을 출력
        List<Integer> answerList = new ArrayList<>();
        // 자바: 배열의 최댓값 구하는 방법
        int maxScore = Arrays.stream(scores).max().getAsInt();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                answerList.add(i + 1);
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}

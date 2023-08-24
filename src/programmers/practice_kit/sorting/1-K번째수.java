package programmers.practice_kit.sorting;

import java.util.*;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        // 배열로 풀 수 있으면 굳이 ArrayList 사용하지 말기
        int[] answer = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            int[] subArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(subArray);
            answer[idx] = subArray[k - 1];
        }

        return answer;
    }
}

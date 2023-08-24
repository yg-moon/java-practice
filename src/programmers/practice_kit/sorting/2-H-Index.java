package programmers.practice_kit.sorting;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // int는 역순 정렬이 안되기 때문에 Integer로 변환
        Integer[] newCitations = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            newCitations[i] = citations[i];
        }

        Arrays.sort(newCitations, Collections.reverseOrder());

        for (int i = 0; i < newCitations.length; i++) {
            if (i >= newCitations[i]) {
                return i;
            }
        }
        return newCitations.length;
    }
}

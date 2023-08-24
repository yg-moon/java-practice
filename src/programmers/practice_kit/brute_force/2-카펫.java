package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        List<Integer> resultList = new ArrayList<>();

        for (int i = 3; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                int height = i;
                int width = area / height;
                if ((width - 2) * (height - 2) == yellow) {
                    resultList.add(width);
                    resultList.add(height);
                    break;
                }
            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}

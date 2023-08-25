package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> resultList = new ArrayList<>();
        int area = brown + yellow;

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

package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        for (int[] size : sizes) {
            Arrays.sort(size);
        }

        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}

package programmers.practice_kit.hash;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int lenHalf = nums.length / 2;

        // list -> set변환: 직접 추가하는게 제일 간단한 방법
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int lenSet = numSet.size();

        return Math.min(lenHalf, lenSet);
    }
}

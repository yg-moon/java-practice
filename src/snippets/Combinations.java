package snippets;

import java.util.*;

public class Combinations {
    static int targetLength = 3;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(nums, new ArrayList<>(), 0, result);
        System.out.println(result);
    }

    private static void generateCombinations(int[] nums, List<Integer> curList, int start, List<List<Integer>> result) {
        if (curList.size() == targetLength) {
            result.add(new ArrayList<>(curList));
            return;
        }

        // 핵심: start부터 끝까지 돌면서, 방문여부는 관리하지 않음
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            generateCombinations(nums, curList, i + 1, result);
            curList.remove(curList.size() - 1);
        }
    }
}

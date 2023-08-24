package snippets;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], result);
        System.out.println(result);
    }

    private static void generatePermutations(int[] nums, List<Integer> curList, boolean[] visited,
            List<List<Integer>> result) {
        if (curList.size() == nums.length) {
            result.add(new ArrayList<>(curList));
            return;
        }

        // 핵심: 처음부터 끝까지 돌면서, 방문여부를 관리하며 재귀
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curList.add(nums[i]);
                visited[i] = true;
                generatePermutations(nums, curList, visited, result);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
    }
}

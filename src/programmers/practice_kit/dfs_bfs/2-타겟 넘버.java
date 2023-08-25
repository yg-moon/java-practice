package programmers.practice_kit.dfs_bfs;

class Solution {
    int cnt = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }

    private void dfs(int[] numbers, int target, int res, int idx) {
        if (idx == numbers.length) {
            if (res == target) {
                cnt++;
            }
            return;
        }
        dfs(numbers, target, res + numbers[idx], idx + 1);
        dfs(numbers, target, res - numbers[idx], idx + 1);
    }
}

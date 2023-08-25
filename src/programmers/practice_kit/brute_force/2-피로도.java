package programmers.practice_kit.brute_force;

class Solution {
    // visited: set보다는 배열이 성능상 유리
    static boolean[] visited;
    static int maxCnt = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return maxCnt;
    }

    private void dfs(int curK, int curCnt, int[][] dungeons) {
        maxCnt = Math.max(maxCnt, curCnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && curK >= dungeons[i][0]) {
                visited[i] = true;
                dfs(curK - dungeons[i][1], curCnt + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}

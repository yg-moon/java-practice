package programmers.practice_kit.dfs_bfs;

class Solution {
    boolean[] visited;
    int networkCnt = 0;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(node, computers);
                networkCnt++;
            }
        }

        return networkCnt;
    }

    private void dfs(int i, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers);
            }
        }
    }
}

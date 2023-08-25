package programmers.practice_kit.dfs_bfs;

import java.util.*;

class Solution {
    final int[] dx = { -1, 1, 0, 0 };
    final int[] dy = { 0, 0, -1, 1 };
    int m;
    int n;

    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        int[][] visited = new int[m][n];

        bfs(maps, visited);

        int answer = visited[m - 1][n - 1];
        return (answer == 0) ? -1 : answer;
    }

    // 자바의 BFS 구현
    private void bfs(int[][] maps, int[][] visited) {
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[] { nx, ny });
                }
            }
        }
    }
}

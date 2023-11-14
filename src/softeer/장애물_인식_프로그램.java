package softeer;

import java.io.*;
import java.util.*;

public class 장애물_인식_프로그램 {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        visited = new boolean[N][N];

        // 그래프 채우기
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j) - '0'; // 꿀팁
            }
        }

        // 핵심 로직
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int cnt = bfs(i, j);
                    result.add(cnt);
                }
            }
        }

        // 결과 출력
        System.out.println(result.size());
        Collections.sort(result);
        for (int x : result) {
            System.out.println(x);
        }
    }

    static int bfs(int start_x, int start_y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start_x, start_y });
        visited[start_x][start_y] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }

        return cnt;
    }
}

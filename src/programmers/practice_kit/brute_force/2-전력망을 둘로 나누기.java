package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    List<Integer>[] tree;
    int cnt;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 그래프 구축
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            tree[x].add(y);
            tree[y].add(x);
        }

        // 하나씩 끊어보며 DFS
        for (int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];

            // 전선 끊기
            // 자바: List.remove()는 오토박싱을 해주지 않으므로 Integer로 변환해줘야 함
            tree[x].remove(Integer.valueOf(y));
            tree[y].remove(Integer.valueOf(x));

            // 아무 노드나 시작점으로 해서 DFS
            cnt = 0;
            dfs(1, new boolean[n + 1]);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));

            // 전선 복구
            tree[x].add(y);
            tree[y].add(x);
        }

        return answer;
    }

    private void dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        cnt++;
        for (int next : tree[cur]) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }
}

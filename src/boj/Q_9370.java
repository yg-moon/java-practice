package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_9370 {
    private static final int INF = (int) 1e9;

    private static int[] dijkstra(int start, int n, Map<Integer, List<int[]>> graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, start});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];

            if (dist[node] < time) {
                continue;
            }

            List<int[]> neighbors = graph.getOrDefault(node, new ArrayList<>());

            for (int[] neighbor : neighbors) {
                int v = neighbor[0];
                int w = neighbor[1];
                int alt = time + w;
                if (dist[v] > alt) {
                    dist[v] = alt;
                    pq.add(new int[]{alt, v});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.putIfAbsent(a, new ArrayList<>());
                graph.putIfAbsent(b, new ArrayList<>());
                graph.get(a).add(new int[]{b, d});
                graph.get(b).add(new int[]{a, d});
            }

            int[] dests = new int[t];
            for (int j = 0; j < t; j++) {
                dests[j] = Integer.parseInt(br.readLine());
            }

            int[] dist_s = dijkstra(s, n, graph);
            int[] dist_g = dijkstra(g, n, graph);
            int[] dist_h = dijkstra(h, n, graph);

            List<Integer> result = new ArrayList<>();
            for (int d : dests) {
                if (dist_s[g] + dist_g[h] + dist_h[d] == dist_s[d]
                        || dist_s[h] + dist_h[g] + dist_g[d] == dist_s[d]) {
                    result.add(d);
                }
            }

            Collections.sort(result);

            for (int r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
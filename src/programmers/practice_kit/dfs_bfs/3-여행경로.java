package programmers.practice_kit.dfs_bfs;

import java.util.*;

class Solution {
    Map<String, Queue<String>> graph = new HashMap<>();
    List<String> route = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        // String 2차원 배열을 정렬하는 방법
        Arrays.sort(tickets, Comparator.comparing(Arrays::toString));

        for (String[] ticket : tickets) {
            String src = ticket[0];
            String dst = ticket[1];
            graph.putIfAbsent(src, new LinkedList<>());
            graph.get(src).add(dst);
        }

        dfs("ICN");
        Collections.reverse(route);
        return route.stream().toArray(String[]::new);
    }

    private void dfs(String airport) {
        // 해당 key가 있는지 먼저 확인하고, 해당 key의 내용물이 비었는지 확인해야 함
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            dfs(graph.get(airport).poll());
        }
        route.add(airport);
    }
}

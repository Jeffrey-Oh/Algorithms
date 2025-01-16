import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, LinkedHashSet<Integer>> graph = new HashMap<>();
        
        for (int[] wire : wires) {
            graph.computeIfAbsent(wire[0], k -> new LinkedHashSet<>()).add(wire[1]);
            graph.computeIfAbsent(wire[1], k -> new LinkedHashSet<>()).add(wire[0]);
        }
        
        int minDifference = Integer.MAX_VALUE;

        // 각 간선을 끊어보고 계산
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            // 간선 끊기
            graph.get(node1).remove(node2);
            graph.get(node2).remove(node1);

            // 서브 트리 크기 계산
            boolean[] visited = new boolean[n + 1];
            int subTreeSize = dfs(graph, node1, visited);

            // 두 트리 크기의 차이 계산
            int difference = Math.abs((n - subTreeSize) - subTreeSize);
            minDifference = Math.min(minDifference, difference);

            // 간선 복구
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        return minDifference;
    }
    
    // DFS로 서브 트리 크기 계산
    private static int dfs(Map<Integer, LinkedHashSet<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int size = 1; // 현재 노드 포함

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(graph, neighbor, visited);
            }
        }

        return size;
    }
}
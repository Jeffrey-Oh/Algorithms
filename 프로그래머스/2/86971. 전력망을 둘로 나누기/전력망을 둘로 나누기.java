import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, LinkedHashSet<Integer>> graph = new HashMap<>();
        for (int[] wire : wires) {
            graph.computeIfAbsent(wire[0], g -> new LinkedHashSet<>()).add(wire[1]);
            graph.computeIfAbsent(wire[1], g -> new LinkedHashSet<>()).add(wire[0]);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            
            graph.get(node1).remove(node2);
            graph.get(node2).remove(node1);
            
            boolean[] visited = new boolean[n + 1];
            int subSize = dfs(graph, node1, visited);
            
            min = Math.min(Math.abs((n - subSize) - subSize), min);
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        return min;
    }
    
    public int dfs(Map<Integer, LinkedHashSet<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int size = 1;
        
        for (int n : graph.get(node)) {
            if (!visited[n])
                size += dfs(graph, n, visited);
        }
        
        return size;
    }
}
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
            graph.get(wire[0]).remove(wire[1]);
            graph.get(wire[1]).remove(wire[0]);
            
            boolean[] visited = new boolean[n + 1];
            int subSize = dfs(graph, wire[0], visited);
            
            min = Math.min(Math.abs((n - subSize) - subSize), min);
            
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        return min;
    }
    
    public int dfs(Map<Integer, LinkedHashSet<Integer>> graph, int start, boolean[] visited) {
        visited[start] = true;
        int sum = 1;
        
        for (int num : graph.get(start)) {
            if (!visited[num]) {
                sum += dfs(graph, num, visited);
            }
        }
        
        return sum;
    }
}
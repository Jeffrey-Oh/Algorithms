import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] distances = bfs(graph, n, 1);
        
        int max = Arrays.stream(distances).max().orElse(0);
        return (int) Arrays.stream(distances).filter(c -> c == max).count();
    }
    
    public int[] bfs(Map<Integer, List<Integer>> graph, int n, int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[start] = 0;
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(start);
        
        while (!ad.isEmpty()) {
            int node = ad.pop();
            
            for (int neighbor : graph.get(node)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[node] + 1;
                    ad.add(neighbor);
                }
            }
        }
        
        return distances;
    }
}
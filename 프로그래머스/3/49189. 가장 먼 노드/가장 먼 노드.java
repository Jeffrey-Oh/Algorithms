import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edge) {
            graph.computeIfAbsent(e[0], g -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], g -> new ArrayList<>()).add(e[0]);
        }
        
        int[] distances = bfs(graph, n, 1);
        
        int max = Arrays.stream(distances).max().orElse(0);
        return (int) Arrays.stream(distances).filter(i -> i == max).count();
    }
    
    public int[] bfs(Map<Integer, List<Integer>> graph, int n, int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[start] = 0;
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(start);
        
        while (!ad.isEmpty()) {
            int node = ad.pop();
            
            for (int num : graph.get(node)) {
                if (distances[num] == -1) {
                    distances[num] = distances[node] + 1;
                    ad.add(num);
                }
            }
        }
        
        return distances;
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], g -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        String current = "ICN";
        List<String> list = new ArrayList<>();
        
        dfs(graph, current, list);
        
        Collections.reverse(list);
        
        return list.toArray(new String[0]);
    }
    
    public void dfs(Map<String, PriorityQueue<String>> graph, String current, List<String> list) {
        PriorityQueue<String> pq = graph.get(current);
        
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(graph, next, list);
        }
        
        list.add(current);
    }
}
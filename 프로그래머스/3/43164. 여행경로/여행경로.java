import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> airports = new HashMap<>();
        for (String[] ticket : tickets) {
            airports.computeIfAbsent(ticket[0], a -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        List<String> result = new ArrayList<>();
        
        dfs("ICN", airports, result);
        
        Collections.reverse(result);
        
        return result.stream().toArray(String[]::new);
    }
    
    public void dfs(String current, Map<String, PriorityQueue<String>> airports, List<String> result) {
        PriorityQueue<String> airport = airports.get(current);
        
        while (airport != null && !airport.isEmpty()) {
            String next = airport.poll();
            dfs(next, airports, result);
        }
        
        result.add(current);
    }
}
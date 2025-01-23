class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;
        
        for (int neighbor = 0; neighbor < computers.length; neighbor++) {
            if (computers[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, computers, visited);
            }
        }
    }
}
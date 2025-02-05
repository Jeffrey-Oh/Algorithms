class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        
        for (int i=0; i<n; i++) {
            int[] computer = computers[i];
            
            if (computer[i] == 1 && !visited[i]) {
                answer++;
                visited[i] = true;
                dfs(visited, computers, i);
            }
        }
        
        return answer;
    }
    
    public void dfs(boolean[] visited, int[][] computers, int k) {
        int[] computer = computers[k];
        
        for (int i=0; i<computer.length; i++) {
            if (computer[i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(visited, computers, i);
            }
        }
    }
}
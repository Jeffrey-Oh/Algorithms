import java.util.*;

class Solution {
    int max;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        search(k, dungeons, 0, visited);
        return max;
    }
    
    public void search(int k, int[][] dungeons, int count, boolean[] visited) {
        max = Math.max(max, count);
        
        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                search(k - dungeons[i][1], dungeons, count + 1, visited);
                visited[i] = false;
            }
        }
    }
}
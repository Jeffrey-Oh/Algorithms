import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        maps[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    q.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        return -1;
    }
}
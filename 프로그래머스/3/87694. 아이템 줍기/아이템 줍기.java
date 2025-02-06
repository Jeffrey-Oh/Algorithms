import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int scale = 2;
        int maxSize = 50 * scale + 2;
        boolean[][] map = new boolean[maxSize][maxSize];
        
        // 테두리
        for (int[] rect : rectangle) {
            int x1 = rect[0] * scale, y1 = rect[1] * scale;
            int x2 = rect[2] * scale, y2 = rect[3] * scale;
            
            for (int x = x1; x<=x2; x++) {
                map[x][y1] = true;
                map[x][y2] = true;
            }
            
            for (int y = y1; y<=y2; y++) {
                map[x1][y] = true;
                map[x2][y] = true;
            }
        }
        
        // 내부
        for (int[] rect : rectangle) {
            int x1 = rect[0] * scale + 1, y1 = rect[1] * scale + 1;
            int x2 = rect[2] * scale - 1, y2 = rect[3] * scale - 1;
            
            for (int x = x1; x<=x2; x++) {
                for (int y = y1; y<=y2; y++) {
                    map[x][y] = false;
                }
            }
        }
        
        int startX = characterX * scale;
        int startY = characterY * scale;
        int targetX = itemX * scale;
        int targetY = itemY * scale;
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY, 0});
        boolean[][] visited = new boolean[maxSize][maxSize];
        visited[startX][startY] = true;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if (x == targetX && y == targetY) {
                return distance / scale;
            }
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < maxSize && ny < maxSize && map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        return -1;
    }
}
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        String color = board[h][w];
        
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        
        for (int i=0; i<4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny].equals(color)) {
                answer++;
            }
        }
        
        return answer;
    }
}
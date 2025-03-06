import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] grid = new char[m][n];

        // 보드를 char 배열로 변환
        for (int i = 0; i < m; i++) {
            grid[i] = board[i].toCharArray();
        }

        int answer = 0;

        while (true) {
            boolean[][] toRemove = new boolean[m][n]; // 제거할 블록 표시
            int removedCount = markBlocksToRemove(grid, toRemove, m, n);
            if (removedCount == 0) break; // 제거할 블록이 없으면 종료

            answer += removedCount;
            applyGravity(grid, m, n);
        }

        return answer;
    }

    private int markBlocksToRemove(char[][] grid, boolean[][] toRemove, int m, int n) {
        int count = 0;

        // 2x2 블록 찾기
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char current = grid[i][j];
                if (current != 'X' &&
                    current == grid[i][j + 1] &&
                    current == grid[i + 1][j] &&
                    current == grid[i + 1][j + 1]) {
                    
                    toRemove[i][j] = true;
                    toRemove[i][j + 1] = true;
                    toRemove[i + 1][j] = true;
                    toRemove[i + 1][j + 1] = true;
                }
            }
        }

        // 블록 제거
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toRemove[i][j]) {
                    grid[i][j] = 'X';
                    count++;
                }
            }
        }

        return count;
    }

    private void applyGravity(char[][] grid, int m, int n) {
        // 열(column)별로 블록을 아래로 내리기
        for (int j = 0; j < n; j++) {
            int emptyRow = m - 1; // 가장 아래에서 채울 위치
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] != 'X') {
                    char temp = grid[i][j];
                    grid[i][j] = 'X';
                    grid[emptyRow][j] = temp;
                    emptyRow--;
                }
            }
        }
    }
}

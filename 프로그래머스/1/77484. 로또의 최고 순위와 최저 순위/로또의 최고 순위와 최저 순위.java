import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 맞춘 번호 -> 최저
        // 맞춘 번호 + 0을 당첨번호로 치환한 총 개수 -> 최고
        Map<Integer, Integer> win = new HashMap<>();
        for (int winNum : win_nums) {
            win.put(winNum, 0);
        }
        
        int count = 0, zero = 0;
        for (int lotto : lottos) {
            if (win.containsKey(lotto)) {
                win.remove(lotto);
                count++;
            }
            if (lotto == 0) zero++;
        }
        
        int sum = count + zero;
        int min = 0, max = 0;
        
        switch (sum) {
            case 6:
                max = 1;
                break;
            case 5:
                max = 2;
                break;
            case 4:
                max = 3;
                break;
            case 3:
                max = 4;
                break;
            case 2:
                max = 5;
                break;
            default:
                max = 6;
                break;
        }
        
        switch (count) {
            case 6:
                min = 1;
                break;
            case 5:
                min = 2;
                break;
            case 4:
                min = 3;
                break;
            case 3:
                min = 4;
                break;
            case 2:
                min = 5;
                break;
            default:
                min = 6;
                break;
        }
        
        return new int[]{max, min};
    }
}
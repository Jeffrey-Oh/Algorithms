import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Map<String, Boolean> map = new HashMap<>();
        int x = 0, y = 0;
        
        for (char c : dirs.toCharArray()) {
            String from = "" + x + y;
            
            switch (c) {
                case 'L':
                    if (x > -5) {
                        x--;
                    }
                    break;
                case 'U':
                    if (y < 5) {
                        y++;
                    }
                    break;
                case 'R':
                    if (x < 5) {
                        x++;
                    }
                    break;
                default:
                    if (y > -5) {
                        y--;
                    }
                    break;
            }
            
            String to = "" + x + y;
            boolean visited1 = map.getOrDefault(from + to, false);
            boolean visited2 = map.getOrDefault(to + from, false);
            
            if (!from.equals(to) && !visited1 && !visited2) {
                answer++;
                map.put(from + to, true);
                map.put(to + from, true);
            }
        }
        
        return answer;
    }
}
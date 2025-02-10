import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] points = new int[3];
        
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : dartResult.toCharArray()) {
            if (c == '*' || c == '#') {
                index--;
                
                if (c == '*') {
                    if (index == 0) {
                        points[0] = points[0] * 2;
                    } else {
                        points[index - 1] = points[index - 1] * 2;
                        points[index] = points[index] * 2;
                    }
                } else {
                    points[index] = points[index] * -1;
                }
                
                index++;
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int point = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                if (c == 'S') {
                    points[index++] = (int) Math.pow(point, 1);
                } else if (c == 'D') {
                    points[index++] = (int) Math.pow(point, 2);
                } else if (c == 'T') {
                    points[index++] = (int) Math.pow(point, 3);
                }
            } else {
                sb.append(c);
            }
        }
        
        return Arrays.stream(points).sum();
    }
}
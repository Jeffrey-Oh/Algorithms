import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if (a != b && a != c && b != c)
            answer = a + b + c;
        else if (a == b && a != c || a == c && a != b || b == c && a != b)
            answer = (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2));
        else if (a == b && a == c) {
            answer = (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2)) * ((int) Math.pow(a, 3) + (int) Math.pow(b, 3) + (int) Math.pow(c, 3));
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int a, int b) {
        String ab = "" + a + b;
        int abInt = Integer.parseInt(ab);
        return Math.max(2 * a * b, abInt);
    }
}
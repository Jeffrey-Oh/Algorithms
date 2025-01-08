import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        return Arrays.stream(num_list).anyMatch(find -> find == n) ? 1 : 0;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] answer = new boolean[n + 1];
        Arrays.fill(answer, true);
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayDeque<Integer> reserves = new ArrayDeque<>();
        for (int res : reserve) reserves.add(res);
        
        ArrayDeque<Integer> losts = new ArrayDeque<>();
        for (int lo : lost) {
            losts.add(lo);
            answer[lo] = false;
        }
        
        while (!reserves.isEmpty()) {
            int res = reserves.pop();
            if (losts.contains(res))
                answer[res] = true;
            else {
                if (losts.contains(res - 1)) {
                    answer[res] = true;
                    answer[res - 1] = true;
                    losts.remove(res - 1);
                    
                    if (reserves.contains(res - 1))
                        reserves.remove(res - 1);
                }
                else if (losts.contains(res + 1)) {
                    answer[res] = true;
                    answer[res + 1] = true;
                    losts.remove(res + 1);
                    
                    if (reserves.contains(res + 1))
                        reserves.remove(res + 1);
                }
                else answer[res] = true;
            }
        }
        
        int count = -1;
        for (boolean b : answer) {
            if (b) count++;
        }
        return count;
    }
}
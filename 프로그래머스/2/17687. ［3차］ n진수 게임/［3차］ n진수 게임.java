import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int index = 0, seq = 1;
        Deque<String> q = new ArrayDeque<>();
        while (q.size() != t) {
            int[] arr = create(q, index++, seq, n, m, p, t);
            seq = arr[0];
            p = arr[1];
        }
        return q.stream().collect(Collectors.joining());
    }
    
    public int[] create(Deque<String> q , int index, int seq, int n, int m, int p, int t) {
        String radix = Integer.toString(index, n);
        String[] split = radix.split("");
        for (String s : split) {
            if (seq++ == p)  {
                if (s.matches("[a-z]")) s = s.toUpperCase();
                q.add(s);
                p += m;
            }
                
            if (q.size() == t) break;
        }
        
        return new int[]{seq, p};
    }
}
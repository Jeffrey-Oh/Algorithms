import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        int idx = 0;
        for (int indice : indices) {
            my_string = my_string.substring(0, indice-idx) + my_string.substring(indice+1-idx++);
        }
        return my_string;
    }
}
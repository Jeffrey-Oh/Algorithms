import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        for (int indice : indices) {
            my_string = my_string.substring(0, indice) + " " + my_string.substring(indice+1);
        }
        return my_string.replace(" ", "");
    }
}
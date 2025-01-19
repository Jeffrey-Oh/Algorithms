import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        for (int i=0; i<number.length() - k; i++) {
            char maxChar = '0';
            
            for (int j=startIndex; j<=k+i; j++) {
                if (number.charAt(j) > maxChar) {
                    maxChar = number.charAt(j);
                    startIndex = j+1;
                }
            }
            
            sb.append(maxChar);
        }
        return sb.toString();
    }
}
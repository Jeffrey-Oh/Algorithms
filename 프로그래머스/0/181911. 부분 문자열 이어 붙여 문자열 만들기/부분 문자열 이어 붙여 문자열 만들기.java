class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        for (int i=0; i<parts.length; i++) {
            int start = parts[i][0];
            int end = parts[i][1];
            
            answer += my_strings[i].substring(start, end+1);
        }
        return answer;
    }
}
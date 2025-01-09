class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int i=0; i<queries.length; i++) {
            StringBuilder sb = new StringBuilder();
            int s = queries[i][0];
            int e = queries[i][1];
            sb.append(my_string.substring(0, s));
            sb.append(new StringBuilder(my_string.substring(s, e+1)).reverse());
            sb.append(my_string.substring(e+1));
            my_string = sb.toString();
        }
        return my_string;
    }
}
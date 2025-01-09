class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string); // 전체 문자열을 StringBuilder로 변환
        
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            
            // s와 e 사이를 뒤집음
            reverseSubstring(sb, s, e);
        }
        
        return sb.toString();
    }
    
    // StringBuilder에서 특정 범위를 뒤집는 메소드
    private void reverseSubstring(StringBuilder sb, int start, int end) {
        while (start < end) {
            // start와 end 위치의 문자 교환
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
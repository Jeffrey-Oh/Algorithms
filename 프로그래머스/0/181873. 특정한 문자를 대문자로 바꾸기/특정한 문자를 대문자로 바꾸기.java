class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for (char c : my_string.toCharArray()) {
            if (c == alp.charAt(0)) {
                answer += alp.toUpperCase();
            } else {
                answer += String.valueOf(c);
            }
        }
        return answer;
    }
}
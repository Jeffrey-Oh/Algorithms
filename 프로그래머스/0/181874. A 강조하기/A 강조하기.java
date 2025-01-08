class Solution {
    public String solution(String myString) {
        String answer = "";
        for (char c : myString.toCharArray()) {
            if (c == 'a' || c == 'A') {
                answer += "A";
            } else if (Character.isUpperCase(c))
                answer += Character.toLowerCase(c);
            else answer += String.valueOf(c);
        }
        return answer;
    }
}
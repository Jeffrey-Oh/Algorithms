class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int i=0; i<code.length(); i++) {
            char c = code.charAt(i);
            if (mode == 0) {
                if (c - '0' != 1) {
                    if (i % 2 == 0)
                        answer.append(c);
                } else mode = 1;
            } else {
                if (c - '0' != 1) {
                    if (i % 2 == 1)
                        answer.append(c);
                } else mode = 0;
            }
        }
        if (answer.toString().isEmpty()) answer.append("EMPTY");
        return answer.toString();
    }
}
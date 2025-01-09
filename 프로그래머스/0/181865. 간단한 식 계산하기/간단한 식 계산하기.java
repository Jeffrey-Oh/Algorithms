class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String left = "";
        String right = "";
        String op = "";
        boolean flag = false;
        for (char c : binomial.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                flag = true;
                op = String.valueOf(c);
            } else if (c != ' ') {
                if (!flag) left += c;
                else right += c;
            }
        }
        switch (op) {
            case "+":
                return Integer.parseInt(left) + Integer.parseInt(right);
            case "-":
                return Integer.parseInt(left) - Integer.parseInt(right);
            default:
                return Integer.parseInt(left) * Integer.parseInt(right);
        }
    }
}
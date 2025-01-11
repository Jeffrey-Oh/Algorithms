class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i=0; i<s.length(); i++) {
            String temp = s;
            while (true) {
                temp = temp.replace("[]", "");
                temp = temp.replace("()", "");
                temp = temp.replace("{}", "");
                
                if (temp.indexOf("[]") == -1 && temp.indexOf("()") == -1 && temp.indexOf("{}") == -1) break;
            }
            if (temp.isEmpty()) answer++;
            s = s.substring(1) + s.substring(0, 1);
        }
        return answer;
    }
}
class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for (int i=0; i<str1.length(); i++) {
            sb.append(s1[i]).append(s2[i]);
        }
        return sb.toString();
    }
}
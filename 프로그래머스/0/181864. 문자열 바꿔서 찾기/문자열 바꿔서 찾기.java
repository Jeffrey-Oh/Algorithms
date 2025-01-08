class Solution {
    public int solution(String myString, String pat) {
        String myString2 = "";
        for (char c : myString.toCharArray())
            if (c == 'A') myString2 += "B";
            else myString2 += "A";
        return myString2.contains(pat) ? 1 : 0;
    }
}
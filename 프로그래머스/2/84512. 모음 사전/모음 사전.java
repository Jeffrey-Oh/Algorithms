class Solution {
    public int solution(String word) {
        int[] weights = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        int result = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = vowels.indexOf(c);
            result += index * weights[i] + 1;
        }
        return result;
    }
}
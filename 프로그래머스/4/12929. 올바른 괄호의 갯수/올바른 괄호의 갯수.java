class Solution {
    public long solution(int n) {
        long[] catalan = new long[n + 1];
        catalan[0] = 1; // 초기값
        
        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        return catalan[n];
    }
}

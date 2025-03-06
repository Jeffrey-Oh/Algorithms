class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            if ((x & 1) == 0) {
                // 짝수라면 +1 하면 조건 만족
                answer[i] = x + 1;
            } else {
                // 홀수라면 가장 낮은 0을 1로 변경하고, 그보다 낮은 1을 0으로 변경
                answer[i] = x + ((x ^ (x + 1)) >> 2) + 1;
            }
        }

        return answer;
    }
}

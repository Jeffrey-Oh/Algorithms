import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        // 모든 조합 생성
        for (int length = 1; length <= numbers.length(); length++) {
            generateCombinations("", numbers, length, uniqueNumbers);
        }
        
        // 소수 개수 세기
        int primeCount = 0;
        for (int number : uniqueNumbers) {
            if (isPrime(number)) {
                primeCount++;
            }
        }
        
        return primeCount;
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    
    // 모든 조합 생성
    private static void generateCombinations(String prefix, String remaining, int targetLength, Set<Integer> result) {
        if (prefix.length() == targetLength) {
            if (!prefix.startsWith("0")) { // 0으로 시작하는 숫자 제외
                result.add(Integer.parseInt(prefix)); // 숫자로 변환하여 추가
            }
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char currentChar = remaining.charAt(i);
            String newPrefix = prefix + currentChar;
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generateCombinations(newPrefix, newRemaining, targetLength, result);
        }
    }
}
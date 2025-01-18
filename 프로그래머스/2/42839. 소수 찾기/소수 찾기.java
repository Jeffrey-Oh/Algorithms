import java.util.*;

class Solution {
    public int solution(String numbers) {
        List<String> list = new ArrayList<>();
        for (int i=1; i<=numbers.length(); i++) {
            generate("", numbers, i, list);
        }
        Set<Integer> answer = new HashSet<>();
        for (String number : list) {
            int num = Integer.parseInt(number);
            if (isPrime(num)) answer.add(num);
        }
        return answer.size();
    }
    
    public void generate(String prefix, String remaining, int length, List<String> results) {
        if (prefix.length() == length) {
            results.add(prefix);
            return;
        }
        
        for (int i=0; i<remaining.length(); i++) {
            generate(
                prefix + remaining.charAt(i),
                remaining.substring(0, i) + remaining.substring(i+1),
                length,
                results
            );
        }
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
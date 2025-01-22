import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> results = new HashSet<>();
        for (int i=1; i<=numbers.length(); i++)
            generate("", numbers, i, results);
        return results.size();
    }
    
    public void generate(String prefix, String input, int length, Set<Integer> results) {
        if (prefix.length() == length && isPrime(Integer.parseInt(prefix))) {
            results.add(Integer.parseInt(prefix));
            return;
        }
        
        for (int i=0; i<input.length(); i++) {
            generate(
                prefix + input.charAt(i),
                input.substring(0, i) + input.substring(i + 1),
                length,
                results
            );
        }
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i=2; i<=Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}
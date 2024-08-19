import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Integer> weightMap = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                weightMap.put(c, weightMap.getOrDefault(c, 0) + (int) Math.pow(10, length - i - 1));
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(weightMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Map<Character, Integer> charToDigit = new HashMap<>();
        int digit = 9;
        for (Map.Entry<Character, Integer> entry : entryList) {
            charToDigit.put(entry.getKey(), digit--);
        }

        int result = 0;
        for (String word : words) {
            int num = 0;
            for (char c : word.toCharArray()) {
                num = num * 10 + charToDigit.get(c);
            }
            result += num;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
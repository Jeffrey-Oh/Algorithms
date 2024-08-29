import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String value = br.readLine();

        // 펠린드롬의 기준
        // 모든 알파벳의 개수가 짝수
        // 모든 알파벳의 개수가 짝수인데 1개만 홀수 -> 홀수를 제일 중앙에 배치
        Map<Character, Integer> alphaMap = new TreeMap<>();
        for (char alpha : value.toCharArray()) {
            alphaMap.put(alpha, alphaMap.getOrDefault(alpha, 0) + 1);
        }

        int oddCount = 0;
        char odd = 0;
        for (Map.Entry<Character, Integer> alpha : alphaMap.entrySet()) {
            if (alpha.getValue() % 2 != 0) {
                oddCount++;
                odd = alpha.getKey();
            }
        }

        // 홀수가 있는데 1개가 아니면
        if (oddCount > 1)
            bw.write("I'm Sorry Hansoo\n");
        else {
            StringBuilder result = new StringBuilder();
            StringBuilder reverse = new StringBuilder();

            for (Map.Entry<Character, Integer> alpha : alphaMap.entrySet()) {
                char key = alpha.getKey();
                int count = alpha.getValue() / 2;
                for (int i=0; i<count; i++)
                    result.append(key);
            }

            reverse.append(result).reverse();

            if (oddCount == 1)
                result.append(odd);

            result.append(reverse);

            bw.write(result + "\n");
        }
        bw.flush();
    }
}
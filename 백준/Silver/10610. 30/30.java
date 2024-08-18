import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        StringBuilder result = new StringBuilder();

        // 30 배수 중 가장 큰 수
        List<Integer> list = Arrays.stream(N.split("")).mapToInt(Integer::parseInt).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        // 3의 배수는 모든 자리수를 더해도 3의 배수여야함
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        // 10의 배수를 확인하기 위해 0이 적어도 1개 있어야함
        if (sum % 3 != 0 || !N.contains("0")) {
            bw.write("-1\n");
            bw.flush();
            return;
        }

        for (Integer integer : list) result.append(integer);

        bw.write(result + "\n");
        bw.flush();
    }
}
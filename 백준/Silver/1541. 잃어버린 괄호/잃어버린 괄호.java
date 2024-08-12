import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] split = line.split("-");
        int result;
        if (split[0].contains("+")) {
            result = Arrays.stream(split[0].split("\\+")).mapToInt(Integer::parseInt).sum();
        } else result = Integer.parseInt(split[0]);

        // 첫번째 그룹을 합산하고 나머지 뒤는 전부 뺀다
        for (int i=1; i<split.length; i++) {
            String[] values = split[i].split("\\+");
            int num = Arrays.stream(values).mapToInt(Integer::parseInt).sum() * -1; // 무조건 뺄거라서 절대값 씌우고 -1 처리
            result += num;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
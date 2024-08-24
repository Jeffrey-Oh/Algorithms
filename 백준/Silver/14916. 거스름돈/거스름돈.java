import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> memo = new HashMap<>();
        int save = 0;
        int result = 0;

        while (n > 0) {
            int divide = n / 5;
            int remainder = n % 5;
            if ((save * 5 + remainder) % 2 == 0) {
                result = divide + (save * 5 + remainder) / 2;
                break;
            }

            n -= 5;
            save++;
        }

        if (result == 0) result = -1;

        bw.write(result + "\n");
        bw.flush();
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] coins = new int[]{500, 100, 50, 10, 5, 1};
        int changes = 1000 - Integer.parseInt(br.readLine());

        int result = 0;
        int i = 0;
        while(changes > 0) {
            if (coins[i] <= changes) {
                result += changes / coins[i];
                changes %= coins[i];
                i++;
            } else i++;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
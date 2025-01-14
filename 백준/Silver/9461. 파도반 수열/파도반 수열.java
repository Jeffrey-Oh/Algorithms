import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n <= 3) {
                bw.write("1\n");
                continue;
            }
            
            long[] dp = new long[n+1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for (int j=1; j<=n-3; j++) {
                dp[j+3] = dp[j] + dp[j+1];
            }
            bw.write(dp[n] + "\n");
        }
        bw.close();
    }
}
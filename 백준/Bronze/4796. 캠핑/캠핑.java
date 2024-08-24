import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = 1;
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(stringTokenizer.nextToken());
            int P = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            if (L == 0 && P == 0 && V == 0) break;

            int days = V / P;
            int remainderDays = V % P;
            int sum = days * L + Math.min(remainderDays, L);

            bw.write(String.format("Case %d: %d\n", i++, sum));
            bw.flush();
        }
    }
}
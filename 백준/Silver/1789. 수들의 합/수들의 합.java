import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger S = new BigInteger(br.readLine());
        BigInteger results = new BigInteger("0");

        for (int i=1; i<=S.longValue(); i++) {
            if ((long) i * (i + 1) / 2 > S.longValue()) {
                break;
            }
            results = results.max(new BigInteger(String.valueOf(i)));
        }

        bw.write(results.longValue() + "\n");
        bw.flush();
    }
}
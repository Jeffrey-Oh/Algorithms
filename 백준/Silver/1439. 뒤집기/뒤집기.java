import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int zeroToOne = 0;
        int oneToZero = 0;
        
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == '0' && S.charAt(i + 1) == '1') {
                zeroToOne++;
            } else if (S.charAt(i) == '1' && S.charAt(i + 1) == '0') {
                oneToZero++;
            }
        }

        if (S.charAt(0) == '0') {
            oneToZero++;
        } else {
            zeroToOne++;
        }

        int result = Math.min(zeroToOne, oneToZero);

        bw.write(result + "\n");
        bw.flush();
    }
}
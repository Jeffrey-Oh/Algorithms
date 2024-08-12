import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int in = Integer.parseInt(br.readLine());
        int result = 0;

        while(in % 5 > 0) {

            in -= 3;
            result++;

            if (in < 0) {
                result = -1;
                break;
            }
        }

        bw.write("" + (result + in / 5));
        br.close();
        bw.close();
    }
}

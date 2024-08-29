import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        String B = stringTokenizer.nextToken();
        String A = stringTokenizer.nextToken();
        StringBuilder result = new StringBuilder();

        A = A.replace("6", "5");
        B = B.replace("6", "5");

        result.append(Integer.parseInt(A) + Integer.parseInt(B));
        result.append(" ");

        A = A.replace("5", "6");
        B = B.replace("5", "6");
        result.append(Integer.parseInt(A) + Integer.parseInt(B));

        bw.write(result + "\n");
        bw.flush();
    }
}
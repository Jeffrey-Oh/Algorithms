import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[size];
        for (int i=0; i<size; i++) arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        Arrays.sort(arr);

        int sum = 0;
        int prev = 0;
        for (int i=0; i<size; i++) {
            prev += arr[i];
            sum += prev;
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        Integer[] arr1 = new Integer[N];
        for (int i=0; i<N; i++) arr1[i] = Integer.parseInt(st1.nextToken());
        Arrays.sort(arr1);

        Integer[] arr2 = new Integer[N];
        for (int i=0; i<N; i++) arr2[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(arr2, Collections.reverseOrder());

        int result = 0;
        for (int i=0; i<N; i++) {
            result += arr1[i] * arr2[i];
        }
        
        bw.write(result + "\n");
        bw.flush();
    }
}
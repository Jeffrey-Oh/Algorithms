import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            meetings[i][0] = start;
            meetings[i][1] = end;
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int sum = 0;
        int end = 0;
        for (int[] meeting : meetings) {
            if (end <= meeting[0]) {
                end = meeting[1];
                sum++;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}
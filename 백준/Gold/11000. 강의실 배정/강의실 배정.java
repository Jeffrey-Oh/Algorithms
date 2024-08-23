import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            meetings[i][0] = start;
            meetings[i][1] = end;
        }

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        int sum = 1; // 첫 수업 미리 포함
        int end = meetings[0][1]; // 첫 수업 끝나는 시간

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(end);

        for (int i=1; i<meetings.length; i++) {
            int start = meetings[i][0];

            if (!pq.isEmpty()) {
                Integer prevEnd = pq.poll();
                if (prevEnd > start) {
                    sum++;
                    pq.offer(prevEnd);
                }
            }
            pq.offer(meetings[i][1]);
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}
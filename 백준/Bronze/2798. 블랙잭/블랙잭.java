import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = -1;
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        List<Integer> list = new ArrayList<>();
        while (st2.hasMoreTokens()) {
            list.add(Integer.parseInt(st2.nextToken()));
        }
        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = list.get(i) + list.get(j) + list.get(k);

                    if (sum <= M) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
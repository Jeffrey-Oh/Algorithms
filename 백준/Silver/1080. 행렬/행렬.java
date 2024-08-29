import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            A[i] = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        }
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            B[i] = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;
        if (N < 3 || M < 3) result = Arrays.deepEquals(A, B) ? 0 : -1;
        else {
            for (int i = 0; i <= N - 3; i++) {
                for (int j = 0; j <= M - 3; j++) {
                    if (A[i][j] != B[i][j]) {
                        toggle3x3(A, i, j);
                        result++;
                    }
                }
            }
            if (!Arrays.deepEquals(A, B))
                result = -1;
        }

        bw.write(result + "\n");
        bw.flush();
    }

    public static void toggle3x3(int[][] array, int startX, int startY) {
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                array[i][j] = 1 - array[i][j];
            }
        }
    }
}
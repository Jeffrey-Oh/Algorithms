import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] lines = new int[M][2];
        int[][] pieceLines = new int[M][2];
        for (int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            lines[i][0] = Integer.parseInt(stringTokenizer.nextToken()); // 6개 패키지 가격
            lines[i][1] = Integer.parseInt(stringTokenizer.nextToken()); // 낱개 가격

            pieceLines[i][0] = lines[i][0]; // 6개 패키지 가격
            pieceLines[i][1] = lines[i][1]; // 낱개 가격
        }

        if (M == 1) {
            if (lines[0][1] * 6 < lines[0][0]) {
                bw.write((N * lines[0][1]) + "\n");
                bw.close();
                return;
            }
        }

        // 패키지 가격이 낱개 6개 구매 가격보다 저렴한 걸로 정렬
        Arrays.sort(lines, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(pieceLines, Comparator.comparingInt(o -> o[1]));

        // 제일 저렴한 패키지 가격이 제일 저렴한 낱개 가격의 6개 가격보다 저렴한 걸로 제일 많이 구매 후
        // 제일 저렴한 패키지 가격 보다 낱개 * 6 한 가격이 높은 낱개 가격으로 나머지 구매
        int result = 0;
        int lineIndex = 0;
        int minPiecePrice = pieceLines[0][1];

        while (N != 0 && lineIndex < M) {
            int packagePrice = lines[lineIndex][0];

            if (N > 6 && minPiecePrice * 6 >= packagePrice) {
                result += N / 6 * packagePrice;
                N %= 6;
            } else if (N > 6 && minPiecePrice * 6 < packagePrice) {
                result += N * minPiecePrice;
                N = 0;
            }

            if (N <= 6) {
                result += Math.min(packagePrice, minPiecePrice * N);
                N = 0;
            }

            lineIndex++;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
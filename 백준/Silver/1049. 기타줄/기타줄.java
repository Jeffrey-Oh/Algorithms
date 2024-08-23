import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int packageCount = N / 6;
        int pieceCount = N % 6;
        int minPackage = Integer.MAX_VALUE;
        int minPiece = Integer.MAX_VALUE;
        int result;

        for (int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int packagePrice = Integer.parseInt(stringTokenizer.nextToken()); // 6개 패키지 가격
            int piecePrice = Integer.parseInt(stringTokenizer.nextToken()); // 낱개 가격

            minPackage = Math.min(minPackage, packagePrice);
            minPiece = Math.min(minPiece, piecePrice);
        }

        if (minPackage < minPiece * 6 && minPackage < minPiece * pieceCount) {
            result = minPackage * (packageCount + 1);
        } else if (minPiece * 6 > minPackage) {
            result = minPackage * packageCount + minPiece * pieceCount;
        } else {
            result = minPiece * N;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
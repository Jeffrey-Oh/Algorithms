import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 처리
        int N = Integer.parseInt(br.readLine()); // 사람 수
        int[] tallerCounts = new int[N]; // 키가 큰 사람이 왼쪽에 몇 명 있는지 기록
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.readLine();
        for (int i = 0; i < N; i++) {
            tallerCounts[i] = Integer.parseInt(st.nextToken());
        }

        // 결과를 저장할 배열 (결과 줄 순서)
        int[] result = new int[N];
        Arrays.fill(result, 0); // 초기값 0으로 설정

        // 줄 세우기 로직
        for (int i = 0; i < N; i++) {
            int tallerCount = tallerCounts[i]; // 현재 사람의 조건
            int position = 0; // 삽입 위치를 찾기 위한 변수

            // 조건을 만족하는 위치 찾기
            for (int j = 0; j < N; j++) {
                if (result[j] == 0) { // 빈 자리
                    if (tallerCount == 0) { // 조건 충족
                        position = j;
                        break;
                    }
                    tallerCount--; // 조건을 줄여감
                }
            }

            // 조건에 맞는 위치에 현재 사람 배치
            result[position] = i + 1; // 키는 1부터 시작
        }

        // 결과 출력
        StringBuilder answer = new StringBuilder();
        for (int num : result) {
            answer.append(num).append(" ");
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
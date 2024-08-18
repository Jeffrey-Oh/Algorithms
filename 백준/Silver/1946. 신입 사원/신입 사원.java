import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        List<Integer> results = new ArrayList<>();

        for (int i=0; i<T; i++) {
            // 지원자 수
            int members = Integer.parseInt(br.readLine());

            // 성적
            int[][] points = new int[members][2];

            int j = 0;
            while (members-- > 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                points[j][0] = Integer.parseInt(stringTokenizer.nextToken());
                points[j++][1] = Integer.parseInt(stringTokenizer.nextToken());
            }

            // 시험 1등의 면접 성적을 기준으로 다음을 필터링
            // 먼저 면접 성적 보다 높은 순위를 모두 필터링 하여 면접 성적 기준으로 정렬
            // 다시 성적 기준으로 반복문을 돌면서 면접 1등 성적을 기준으로 시험 성적을 역순으로 체크
            // 순위가 낮은 결과는 패스
            points = Arrays.stream(points).sorted(Comparator.comparingInt(o -> o[0])).toArray(int[][]::new);
            int maxResumeInterViewPoint = points[0][1]; // 1 4
            int[][] resumes = Arrays.stream(points)
                .filter(point -> point[1] < maxResumeInterViewPoint)
                .toArray(int[][]::new);

            if (resumes.length == 0) {
                results.add(1);
                continue;
            }

            resumes = Arrays.stream(resumes).sorted(Comparator.comparingInt(o -> o[1])).toArray(int[][]::new);

            int sum = 2; // 시험 1등 + 면접 1등
            int maxResume = resumes[0][0];
            for (int k=1; k<resumes.length; k++) {
                int resume = resumes[k][0];
                if (resume < maxResume) {
                    sum++;
                    maxResume = resume;
                }
            }

            results.add(sum);
        }

        for (Integer result : results) {
            bw.write(result + "\n");
            bw.flush();
        }
    }
}
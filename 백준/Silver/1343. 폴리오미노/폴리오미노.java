import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();
        boolean flag = true;
        String pm = br.readLine();

        if (pm.startsWith(".")) flag = false;

        // X 그룹과 . 그룹을 나눔
        Queue<String> x = new LinkedList<>();
        Queue<String> dot = new LinkedList<>();

        StringBuilder group = new StringBuilder();
        for (char c : pm.toCharArray()) {
            if (c == 'X') {
                if (group.toString().startsWith(".")) {
                    dot.add(group.toString());
                    group = new StringBuilder();
                }
                group.append(c);
            } else {
                if (group.toString().startsWith("X")) {
                    x.add(group.toString());
                    group = new StringBuilder();
                }
                group.append(c);
            }
        }

        if (group.length() > 0) {
            if (group.toString().startsWith("X"))
                x.add(group.toString());
            else
                dot.add(group.toString());
        }

        while (!(x.isEmpty() && dot.isEmpty())) {
            if (flag) {
                if (!x.isEmpty()) {
                    String xPoll = x.poll();
                    xPoll = xPoll
                        .replace("XXXX", "AAAA")
                        .replace("XX", "BB");

                    if (xPoll.contains("X")) {
                        answer = new StringBuilder("-1");
                        break;
                    }

                    answer.append(xPoll);

                    if (!dot.isEmpty()) {
                        String dotPoll = dot.poll();
                        answer.append(dotPoll);
                    }
                }
            } else {
                if (!dot.isEmpty()) {
                    String dotPoll = dot.poll();
                    answer.append(dotPoll);

                    if (!x.isEmpty()) {
                        String xPoll = x.poll();
                        xPoll = xPoll
                            .replace("XXXX", "AAAA")
                            .replace("XX", "BB");

                        if (xPoll.contains("X")) {
                            answer = new StringBuilder("-1");
                            break;
                        }

                        answer.append(xPoll);
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
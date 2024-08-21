import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<N; i++) numbers.add(Integer.parseInt(br.readLine()));
        numbers.sort(Comparator.comparingInt(value -> value));

        int result = 0;

        if (N == 1) result += numbers.get(0);
        else {
            List<Integer> minusList = numbers.stream().filter(number -> number < 0).collect(Collectors.toList());
            int minusSize = minusList.size();
            if (minusSize % 2 == 0) {
                for (int i=0; i<minusSize; i=i+2) result += minusList.get(i) * minusList.get(i + 1);
            } else {
                for (int i=0; i<minusSize - 1; i=i+2) result += minusList.get(i) * minusList.get(i + 1);
            }

            List<Integer> plusList = numbers.stream().filter(number -> number >= 0).collect(Collectors.toList());
            int plusSize = plusList.size();

            if (minusSize % 2 == 1) {
                if (plusSize > 0) {
                    if (plusList.get(0) != 0)
                        // 음수가 1개 남았는데 양수의 첫번째가 0이 아닌 경우는 음수 합산
                        result += minusList.get(minusSize - 1);
                } else result += minusList.get(minusSize - 1);
            }

            if (plusSize == 1) {
                if (result < 0 && plusList.get(0) == 0) {
                    result = 0;
                } else {
                    result += plusList.get(0);
                }
            } else {
                int sizeUpdate = 0;
                for (int i=0; i<plusSize; i=i+2) {
                    int number = plusList.get(i);
                    int nextNumber = plusList.get(i + 1);

                    if (number == 0 && nextNumber != 0) {
                        if ((plusSize - sizeUpdate) % 2 == 0) {
                            if (result == -1)
                                result = nextNumber;
                            else result += nextNumber;
                        }
                        else {
                            sizeUpdate = -1;
                            i--;
                        }
                    } else {
                        if (number == 1 && nextNumber == 1) {
                            if ((plusSize - sizeUpdate) % 2 == 0) {
                                result += number + nextNumber;
                            } else {
                                result += number;
                                sizeUpdate = -1;
                                i--;
                            }
                        } else {
                            if ((plusSize - sizeUpdate) % 2 == 0) {
                                if (number == 1) {
                                    result += number + nextNumber;
                                } else {
                                    result += number * nextNumber;
                                }
                            } else {
                                result += number;
                                sizeUpdate = -1;
                                i--;
                            }
                        }
                    }
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
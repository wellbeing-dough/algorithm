package codeplus.algorithm_basic.math;

import java.util.Arrays;
import java.util.OptionalInt;

public class CodingTest1 {

    public static void main(String[] args) {

        int [] boxes = new int[3];
        boxes[0] = 1000;
        boxes[1] = 800;
        boxes[2] = 900;

        System.out.println(solution1(boxes, 1000000, 3));
    }

    public static int solution1(int[] boxes, int m, int k) {
        int answer = 0;
        int[] result = new int[boxes.length];
        for (int i = 0; i < k; i++) {
            Arrays.fill(result, 0);
            int rate = m / 10000;
            for (int j = 0; j < boxes.length; j++) {
                if (rate * boxes[j] > 100000) {
                    continue;
                }
                result[j] = rate * boxes[j];
            }
            m = m + Arrays.stream(result).max().getAsInt();
        }
        answer = m;
        return answer;
    }

    public static int solution(int [] boxes, int m, int k) {
        int answer = m;
        for (int i = 0; i < k; i++) {
            int rate = answer / 10000;
            int max = 0;
            for (int j = 0; j < boxes.length; j++) {
                if (boxes[j] * rate <= 100000 & max < boxes[j] * rate) {
                    max = boxes[j] * rate;
                }
            }
            answer = answer + max;
        }
        return answer;
    }
}

package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p10819 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int ans = 0;
        while(true) {

            int tmp = calculate(a);
            ans = Math.max(ans, tmp);

            if (next_permutation(a) == false) {
                break;
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

    public static int calculate(int a[]) {
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            sum += Math.abs(a[i] - a[i-1]);
        }
        return sum;
    }

    public static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}

// 들어온 숫자 배열을 전부 다 하나씩 다음 순열을 구해서 그 수열을 식대로 계산해준다
// 물론 처음 들어온 순열을 전부 sort 해줘야 모든 순열을 볼 수 있다
package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p10974 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int [] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        while(true) {

            for (int i = 0; i < n; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");

            if (next_permutation(a) == false) {
                break;
            }

        }
        System.out.println(sb);
    }

    private static boolean next_permutation(int[] a) {

        int i = a.length - 1;

         while(i > 0 && a[i - 1] >= a[i]) {
             i -= 1;
        }

        if(i <= 0) {
            return false;
        }

        int j = a.length - 1;

        while(a[i - 1] >= a[j]) {
            j -= 1;
        }

        int tmp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = tmp;

        j = a.length - 1;
        while(i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}

// 만약에 순열이 7 2 3 6 5 4 1 이라면 -> 7 2 4 1 3 5 6
// 1 2 3 4, 1 2 4 3, 1 3 2 4, 1 3 4 2, 1 4 2 3, 1 4 3 2
// p10972 다음순열을 계속 출력해주면 된다
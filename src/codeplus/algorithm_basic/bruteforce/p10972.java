package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p10972 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (next_permutation(a)) {
            for (int i=0; i<n; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
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

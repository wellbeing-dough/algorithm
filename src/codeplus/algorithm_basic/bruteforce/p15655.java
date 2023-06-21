package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p15655 {
    static int n, m;
    static boolean c[]; static int a[]; static int num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        c = new boolean[n + 1];
        a = new int[m + 1];
        num = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        go(1);
        System.out.println(sb);
    }

    private static void go(int index) {

        if(index == m + 1) {
            for(int i = 1; i <= m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {

            if((c[i] == true) || (num[i] < a[index - 1])) {
                continue;
            }

            c[i] = true;
            a[index] = num[i];
            go(index + 1);
            c[i] = false;

        }


    }
}

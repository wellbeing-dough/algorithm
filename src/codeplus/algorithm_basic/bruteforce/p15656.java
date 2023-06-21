package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p15656 {
    static int n, m;
    static int a[]; static int num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[m];
        num = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        go(0);
        System.out.println(sb);

    }
    private static void go(int index) {

        if(index == m) {
            for(int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            a[index] = num[i];
            go(index + 1);
        }
    }
}

// 중복을 제거해주는 c 배열만 삭제하면 된다
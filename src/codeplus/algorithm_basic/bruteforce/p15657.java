package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p15657 {
    static int n, m;
    static int a[]; static int num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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

            if(num[i] < a[index -1]) {
                continue;
            }

            a[index] = num[i];
            go(index + 1);

        }

    }
}

// 비 오름차순이기 때문에 c는 없에고 내림차순인것들만 continue(47번째줄)해주면 된다
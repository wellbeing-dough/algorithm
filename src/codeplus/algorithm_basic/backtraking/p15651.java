package codeplus.algorithm_basic.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15651 {
    static int n, m;
    static int a[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];

        go(0);
        System.out.println(sb);
    }

    public static void go(int index) {
        if(index == m) {
            for(int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            a[index] = i;
            go(index + 1);
        }

    }
}

// n과m(1) p15649 문제에서 중복숫자를 판별하는 c만 뺴면 된다
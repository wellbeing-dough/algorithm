package codeplus.algorithm_basic.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15650 {
    static int n, m;
    static boolean c[]; static int a[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        c = new boolean[n + 1];
        a = new int[m + 1];

        go(1);

        System.out.println(sb);
    }

    public static void go(int index) {
        if(index == m + 1) {
            for(int i = 1; i <= m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if((c[i] == true) || (a[index - 1] > i)) {
                continue;
            }
            a[index] = i;
            c[i] = true;
            go(index+1);
            c[i] = false;
        }
    }
}

// n과m(1) p15649 문제에서 오름차순인것만 해주면된다 뭐냐? a배열에서 전에 있던숫자보다 새로운 숫자가 넣어야된다
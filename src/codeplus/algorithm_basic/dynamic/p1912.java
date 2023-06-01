package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int [] a = new int[n + 1];
        int [] d = new int[n + 1]; //i번째 수로 끝나는 가장 큰 연속합

        String insert = br.readLine();
        st = new StringTokenizer(insert, " ");

        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        d[1] = a[1];

        for(int i = 2; i <= n; i++) {
            d[i] = Math.max(a[i] + d[i - 1], a[i]);
        }

        int max = d[1];

        for(int i = 2; i <= n; i++) {
            if(max < d[i]) {
                max = d[i];
            }
        }

        System.out.println(max);

    }
}

// 점화식: d[i] = Math.max(a[i] + d[i - 1], a[i])
// a[] = 10  -4  3  1  5  6  -35  12  21  -1 이면
// d[] = 10   6  9 10 15 21  -14  12  33  32 이다 여기서 최대값
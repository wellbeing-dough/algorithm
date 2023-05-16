package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int[] d = new int[t + 1];
        int[] p = new int[t + 1];

        String insert = br.readLine();
        st = new StringTokenizer(insert, " ");

        for(int i = 1; i <= t; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= t; i++) {
            for(int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i-j] + p[j]);
            }
        }
        System.out.println(d[t]);
    }
}

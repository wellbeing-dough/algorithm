package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p1748 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        int len = 1;
        for(int i = 1; i <= n; i = i * 10) {
            int end = i * 10 - 1;
            if(end > n) {
                end = n;
            }
            ans = ans + (end - i + 1)*len;
            len++;
        }

        System.out.println(ans);
    }
}

// 수의 자리수별로 나누어서 문제를 해결할 수 있다
// N = 120
// 1 ~ 9 -> (9 - 1 + 1) * 1
// 10 ~ 99 -> (99 - 10 + 1) * 2
// 110 ~ 120 -> (120 - 100 + 1) * 3


package codeplus.algorithm_basic.dynamic;

import java.io.*;
import java.util.*;
public class p1699 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] d = new int[n + 1];  //i를 제곱수의 합으로 나타냈을 때, 필요한 항의 최소 개수

        for(int i = 1; i <= n; i++) {
            d[i] = i;
            for(int j = 1; j * j <= i; j++) {
                if(d[i] > d[i - j * j] + 1) {
                    d[i] = d[i - j * j] + 1;
                }
            }
        }

        System.out.println(d[n]);

    }
}

// j의 숫자가 그 제곱수를 i가 몇개 포함할 수 있는지 알 수 있다
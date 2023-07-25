package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p1182 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 1; i < (1 << n); i++) {    // 모든 부분수열을 만든다
            int sum = 0;
            for (int k = 0; k < n; k++) {       // 집합 i를 만들고
                if ((i & (1 << k)) != 0) {      // 각각의 k번째 수가 포함되어있는지 하나씩 판단해 보면서
                    sum += arr[k];              // 포함되어있으면 합을 저장
                }
            }
            if (sum == s) {                     // 합이 s와 같으면 + 1
                ans += 1;
            }
        }
        System.out.println(ans);

    }

}

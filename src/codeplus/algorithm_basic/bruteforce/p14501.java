package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p14501 {

    static StringBuilder sb = new StringBuilder();
    static int n; static int ans;

    static int[] t; static int[] p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 퇴사까지 남은 일

        t = new int[n];  //상담을 완료하는데 걸리는 기간 t
        p = new int[n];  //상담을 했을 때 받을 수 잇는 금액 p

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;    //최대값

        go(0, 0);

        System.out.println(ans);

    }

    private static void go(int day, int sum) {

        if(day == n) {      // 정답을 찾은 경우 계산한 day가 퇴사 예정일이 되면
            if(sum > ans) {
                ans = sum;
            }
            return;
        }

        if(day > n) {   // 상담때문에 퇴사일을 넘어선 경우
            return;
        }

        go(day + t[day], sum + p[day]); //해당 날짜(day)에 상담을 하는경우
        go(day + 1, sum);   //해당 날짜(day)에 상담을 안하는 경우

    }
}

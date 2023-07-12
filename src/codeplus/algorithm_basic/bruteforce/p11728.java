package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p11728 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int s = 0;

        while(t-- > 0) {

            String[] line = br.readLine().split(" ");

            if(line[0].equals("add")) {
                int num = Integer.valueOf(line[1]) - 1; // num - 1인 이유는 20이 들어왔을 때 2^19 자리가 20번째이기 때문이다.
                s = (s | (1 << num));
            }

            if(line[0].equals("remove")) {
                int num = Integer.valueOf(line[1]) - 1;
                s = (s & ~(1 << num));
            }

            if(line[0].equals("check")) {
                int num = Integer.valueOf(line[1]) - 1;

                int tmp = (s & (1 << num));
                if(tmp == 0) {
                    sb.append("0\n");
                } else {
                    sb.append("1\n");
                }
            }

            if(line[0].equals("toggle")) {
                int num = Integer.valueOf(line[1]) - 1;
                s = (s ^ (1 << num));
            }

            if(line[0].equals("all")) {
                s = (1 << 20) - 1;  //20인 이유는 최대 숫자가 20이기 때문
            }

            if(line[0].equals("empty")) {
                s = 0;
            }
        }

        System.out.println(sb);

    }
}

// 비트마스크는 정수로 집합을 나타낼 수 있다 -> {1, 3, 4, 5, 9} == 570 == 1^1 + 2^3 + 2^4 + 2^5 + 2^9
// n이 포함되어 있는지 검사 -> 580 & 2^n == 570 & (1<<0) 0이면 포함되어 있지 않고 그 외의 숫자는 포함되어 있음
// n 추가하기 -> 570 | 2^n == 570 | (1<<n)
// n 제거하기 -> 570 & ~2^n == 570 & ~(1<<n)
// n 토글하기 -> 570 ^ 2^n == 570 ^ (1<<n)
// 전체 집합 -> (1 << N) - 1
// 공집합 -> 0
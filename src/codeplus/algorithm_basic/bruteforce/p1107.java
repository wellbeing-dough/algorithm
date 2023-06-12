package codeplus.algorithm_basic.bruteforce;

import java.io.*;
import java.util.*;

public class p1107 {

    static boolean [] broken = new boolean[10];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int brokenCount = sc.nextInt();
        for (int i = 0; i < brokenCount; i++) {
            int x = sc.nextInt();
            broken[x] = true;
        }

        int ans = n - 100;
        if(ans < 0) {
            ans = -ans;
        }

        for(int i = 0; i <= 1000000; i++) {

            int c = i;
            int len = possible(c);
            if(len > 0) {
                int possible = n - c;
                if(possible < 0) {
                    possible = -possible;
                }
                if(ans > possible + len) {
                    ans = possible + len;
                }
            }
        }

        System.out.println(ans);

    }

    private static int possible(int c) {

        int len = 0;

        if(c == 0) {
            if(broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        while(c > 0) {
            if(broken[c % 10]) {
                return 0;
            }
            c = c / 10;
            len++;
        }

        return len;

    }
}

// i부터 해서 모든 숫자를 봐보면서 가고싶은 채널 숫자까지 위아래로 얼마나 더 입력해야 하는지 확인하는거다
// 만약에 5000번 가고싶은데 5가 고장났다
// i가 4999라면 len은 4를 리턴하고 메인에 for문 안에서는 5000 - 4999 해서 1이 되고 기존 ans보다 작으니까 ans = 1 된다
// len + 1 = 5 가된다 -> 4999+
// 여기서 5000 가보자 그럼 10 나누는거에서 broken[5] == flase 니까 0을 리턴한다
// 만약에 5000번 가고싶은데 그냥 i가 5000일때 len 5000에다가 5000 - 5000 이니까 len + 0 = 4 가 된다
// 빡구현풀때 최적의 해를 찾으려하지말고 전부 싹다해봐서 그중에 해가 되는것을 찾자

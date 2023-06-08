package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1; int s = 1; int m = 1;

        for(int i = 1; i <= 7980; i++) {

            if(E == e && S == s && M == m) {
                System.out.println(i);
                break;
            }

            e++;
            s++;
            m++;

            if(e == 16) {
                e = 1;
            }
            if(s == 29) {
                s = 1;
            }
            if(m == 20) {
                m = 1;
            }
        }

    }
}

// 브루트포스가 뭔지 알겠다 그냥 진짜 싹다 해보는거다 이건 아무리 높아도 15 * 28 * 18 = 7980 이니까 싹다 구현해봐도된다
// 싹다 해보자 그냥
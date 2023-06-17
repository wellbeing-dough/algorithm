package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p6064 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            x = x - 1;
            y = y - 1;

            boolean ok = false;

            for(int i = x; i < (n*m); i = i + m) {
                if(i % n == y) {
                    ok = true;
                    System.out.println(i + 1);
                    break;
                }
            }

            if(ok == false) {
                System.out.println(-1);
            }

        }

    }
}

//규칙을 찾아보면  x가 M만큼 증가할 때 마다 x의 값은 동일하고 y의 값만 변한다.
//마찬가지로, y가 N만큼 증가할때 y의 값은 동일하고 x의 값만 변한다.
//나머지연산(%)을 이용해 답을 구할 수 있다.
//예를들어, 찾는 숫자가 <4,5> == 19라면
//(19%5) = 4 ,  (19%7) == 5를 도출해낼 수 있다.
//단, 나머지값이 0이 나오는 것을 방지하기 위해 모든 x와 y의 값에서 1을 빼준다
//m씩 증가시키면서
//(i%N) == y 가 나오는 값을 구하고,  +1을 해주면 된다.

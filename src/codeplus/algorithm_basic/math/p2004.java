package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class p2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String insert = bf.readLine();

        StringTokenizer st = new StringTokenizer(insert, " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long twoCount = 0, fiveCount = 0;

        for(long i = 2; i <= n; i = i * 2) {
            twoCount = twoCount + n/i;
        }
        for(long i = 2; i <= m; i = i * 2) {
            twoCount = twoCount - m/i;
        }
        for(long i = 2; i <= n-m; i = i * 2) {
            twoCount = twoCount - (n-m)/i;
        }

        for(long i = 5; i <= n; i = i * 5) {
            fiveCount = fiveCount + n/i;
        }
        for(long i = 5; i <= m; i = i * 5) {
            fiveCount = fiveCount - m/i;
        }
        for(long i = 5; i <= n-m; i = i * 5) {
            fiveCount = fiveCount - (n-m)/i;
        }

        System.out.println(min(twoCount, fiveCount));

    }
}

// nCm 은 n!/(n-m)! * m! 이다 그럼 n! 의 0의 개수애서 (n-m)! 의 0의 개수 + m!의 0의 개수를 빼주면 된다
// 하지만 P1676 문제와는 다르게 인수분해 했을때 2보다 5가 더 적을 수 있기 때문에 둘다 구해주고 그중에 더 적은 수를 출력 해줘야 한다
// 예를들어 8 팩토리얼에 2를 인수로 가지고 있는 개수는, 1 2 3 4 5 6 7 8 중에서 for문 첫번째에서 8/2 = 4 이다 뭐냐? 2 4 6 8 이다
// 두번쨰 for문에서 8/4 = 2 다 뭐냐? 4 8 이다 세번째 for문은 8/8 = 1 이다 뭐냐? 8 이다 이해 하길...
// for문도 long 을 해줘야 된다 그렇지 않고 int i = 0; 을 하면 int 범위가 벗어나면 /zero 에러가 뜬다

// 1 2 3 4 5 6 7 8 9 10 11 12 13 14
// for 1 = 7 for 2 = 2 for 1

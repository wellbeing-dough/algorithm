package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long [][] d = new long[n+1][2]; //i자리 이친수의 개수 중에서 j로 끝나는 것의 개수(j=0,1)

        d[1][0] = 0;
        d[1][1] = 1;

        for(int i = 2; i <= n; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }

        System.out.println(d[n][0] + d[n][1]);

    }
}

// 슬슬 dp에 대해 감이 잡힌다 그냥 문제보이면 종이펴서 초반부분을 직접 써보면서 점화식을 만들어보고 거기서 나올 수 있는 예외들을 생각해보자
// 여기서도 d[1][0] = 0, d[1][1] = 1(1) 이고 d[2][0] = 1(10), d[2][1] = 0 이다 좀 더 써보자
// d[3][0] = 1(100) d[3][1] = 1(101) 이다 그럼 뭐냐? 1이 두번연속 못나오고 0은 두번연속 나올 수 있다 그럼
// d[n][0] = d[n-1][0] + d[n-1][1] 이고 d[n][1] = d[n-1][0] 이다 근데 숫자의 시작은 무조건 1이니까 d[1][0] = 0, d[1][1] = 1
// 이걸로 초기세팅하고 점화식 구현하면 된다
// 그리고 이런 dp문제는 값이 엄청 커지니까 long으로 하
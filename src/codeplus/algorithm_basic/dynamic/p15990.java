package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15990 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        long[][] d = new long[1000001][4];  //i를 1,2,3의 합으로 나타내는 방법의 수,마지막에 사용한 수는 j

        d[1][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;

        for (int i = 4; i <= 100001; i++) {
            d[i][1] = (d[i-1][2] + d[i-1][3]) % 1000000009;
            d[i][2] = (d[i-2][1] + d[i-2][3]) % 1000000009;
            d[i][3] = (d[i-3][1] + d[i-3][2]) % 1000000009;
        }

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((d[n][1] + d[n][2] + d[n][3]) % 1000000009 + "\n");
        }
        System.out.println(sb);
    }
}

// p9095 1,2,3 더하기 문제에서 연속으로 중복된 숫자만 제거해주면 된다
// D[i][1]=i를1,2,3의 합으로 나타내는 방법의 수,마지막에 사용한 수는 1 -> D[i][1] = D[i-1][2] + D[i-1][3]
// D[i][2]=i를1,2,3의 합으로 나타내는 방법의 수,마지막에 사용한 수는 2 -> D[i][2] = D[i-2][1] + d[i-2][3]
// D[i][3]=i를1,2,3의 합으로 나타내는 방법의 수,마지막에 사용한 수는 3 -> D[i][3] = D[i-3][2] + D[i-3][3]
// 이렇게 d[i]의 마지막 숫자가 1이면 d[i-1]맨 마지막에 2가 오거나 3이 와야된다
// 그럼 p9095처럼 초기값을 넣어주기 위해서 종이를 꺼내서 직접 d[3]까지 구해봤다
// d[1] = 1 이니까 d[1][1]
// d[2] = 2 니까 d[2][2]
// d[3] = 2+1(d[3][1]), 1+2(d[3][2]), 3(d[3][3])
// d[4] = 1+2+1(d[4][1]), 1+3(d[4][3]), 3+1(d[4][1]) 이다
// d[4] 를 알고리즘으로 구해보면
// d[4][1] = d[3][2] + d[3][3] = 1 + 1 = 2
// d[4][2] = d[2][1] + d[2][3] = 0
// d[4][3] = d[1][1] + d[1][2] = 1 + 0 = 1
// 이렇게 된다 모르겠으면 직접 값 넣어봐 4까지
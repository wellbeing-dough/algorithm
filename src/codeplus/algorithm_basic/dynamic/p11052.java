package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int[] d = new int[t + 1]; //카드를 구매하는 비용의 최대값이 들어있는 배열
        int[] p = new int[t + 1]; //해당 번째의 카드의 가격

        String insert = br.readLine();
        st = new StringTokenizer(insert, " ");

        for(int i = 1; i <= t; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= t; i++) {
            for(int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i-j] + p[j]);
            }
        }
    }
}

// for문 두개를 잘 봐야된다 d[2]를 구한다는것은 카드를 2개살때 최대 비용을 구하는 건데 그렇다면 for문이 두개가 돌아간다
// i=2, j=1 일 때 d[1] + p[1](d[1] 까지 구한거에서 카드 1을 두번살 때) i=2, j=2 일때 d[0] + p[2](카드 2를 한번살 때) 둘중 큰 값이다
// 그럼 d[3]은? for문이 세번돈다 근데 아까 d[2]까지는 확실하게 카드 2개살때 최대 비용을 구했다
// i=3, j=1 일 때 d[2] + p[1](d[2] 까지 구한거에서 카드 1을 한번살 때)
// i=3, j=2 일 때 d[1] + p[2](d[1] 까지 구한거에서 카드 2를 한번 살 때)
// i=3, j=3 일 때 d[0] + p[3](카드 3번 한번살 때)
// 이런식의 값을 구할 때 for문의 형식을 배웠다
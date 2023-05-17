package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int[] d = new int[t+1]; //카드를 구매하는 비용의 최대값이 들어있는 배열소
        int[] p = new int[t+1]; //해당 번째의 카드의 가격

        Arrays.fill(d, 1000 * 10000);
        d[0] = 0;
        String insert = br.readLine();
        st = new StringTokenizer(insert, " ");

        for(int i = 1; i <= t; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= t; i++) {
            for(int j = 1; j <= i; j++) {
                d[i] = Math.min(d[i], d[i-j] + p[j]);
            }
        }
        System.out.println(d[t]);

    }
}

// p11052 카드 구매하기 문제에서 달라진건 최소값을 구하는것만 달라졌다 그럼 min만 쓰면 될것같은데 그러면 안된다
// 카드를 구매하는 비용은 0보다 크기 때문에, min의 결과는 항상 0이다. 따라서 배열의 초기값을 잘 설정해야 한다
// 나는 카드의 개수가 1000이하이고 카드팩의 가격이 10000 이기 때문에 1000 * 10000 을 해줬다
// 하지만 d[0] = 0 을 해줬다 왜냐하면 0의 카드를 구매하는 비용의 최소값은 0이니까
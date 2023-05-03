package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String insert = br.readLine();

        st = new StringTokenizer(insert, " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int [] distance = new int [n];
        String bro = br.readLine();
        st = new StringTokenizer(bro, " ");
        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            distance[i] = Math.abs(value - s);
        }

        int x = distance[0];  // 초기값 설정

        for (int i = 1; i < n; i++) { // 초기값 설정해줬으니까 1부터
            x = gcd(distance[i], x);
        }

        System.out.println(x);
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}

// 이 문제를 풀기 위해 결국엔 동생들과의 거리들의 최대공약수를 찾는 문제이다 distance 배열에 각 동생들과의 거리를 전부 넣어주고 전부 최대공약수때려줬다
// a b c d 의 최대공약수는 gcd(gcd(gcd(a, b), c), d) 이런식으로 해주면 된다 그렇게 하기위해 일단 x에 초기값 설정 해주고 계속 최대공약수를
// 덧붙였다
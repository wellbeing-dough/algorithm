package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        int [] d = new int[12]; // i를 1,2,3의 합으로 나타내는 방법의 수
        d[0] = 1;   //0도 공집합이다 1을0개2를0개3을0개 썻다는 1가지의 방법
        d[1] = 1;   //1
        d[2] = 2;   //1+1, 2
        d[3] = 4;   //1+1+1, 2+1, 1+2, 3
        d[4] = 7;   //1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1

        for(int i = 5; i <= 11; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        while(t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            sb.append(d[n] + "\n");
        }
        System.out.println(sb);
    }
}

// 이문제를 풀면서 깨닳았다 dp문제는 직접 팬을 들고와서 작은부분을 그려보면서 큰문제를 푸는게 맞는거같다
// 이해가 안되면 ppt 그림을보자 저렇게 4까지 해놓고 사실 3까지 해도된다 근데 이해를 돕기위해서 ㅎ
// 그럼 d[i] = d[i-1] + d[i-2] + d[i-3] 이게 점화식이되고 이게 전부이다
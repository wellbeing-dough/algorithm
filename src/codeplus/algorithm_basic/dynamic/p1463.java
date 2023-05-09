package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] d = new int[n+1]; //만들어지면 전부 0으로 채워지기 때문에 d[1] = 0 넣을 필요 없음


        for(int i = 2; i <= n; i++) {

            d[i] = d[i - 1] + 1;

            if(i % 2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }

            if(i % 3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        System.out.println(d[n]);
    }
}

//n = 10이라면 배열에 있는 원소는 거기 부터 1까지 갈 수 있는 최단 횟수 이다 d[8] 은 8부터 1까지 갈 수 있는 최단 횟수 이다 나중에 봤을때 이해 안되면 그냥
//종이랑 팬 꺼내서 n = 10넣고 해보면 된다 이 문제를 풀면서 피보나치 수열과 연관 지어서 dp가 뭔지 확실히 알았다
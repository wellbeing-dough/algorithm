package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String insert = bf.readLine();
        st = new StringTokenizer(insert, " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sb.append((a+b)%c + "\n");
        sb.append(((a%c)+(b%c))%c + "\n");
        sb.append((a * b) % c + "\n");
        sb.append(((a%c)*(b%c) + c)%c + "\n");

        System.out.println(sb);
    }
}
// 0 <= a % c < c, 0 <= b % c < c 기 때문에 (a % c - b % c) 의 결과는 -c < (a % c - b % c) < c 를 만족한다
//따라서 (a % c - b % c + c) 는 0보다 큰 값을 가지기 때문에 이 상태에서 다시 c로 나눠주면 원하는 결과를 얻을 수 있다.
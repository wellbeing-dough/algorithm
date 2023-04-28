package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());

        while(t-- > 0) {
            long result = 0;
            String insert = bf.readLine();
            st = new StringTokenizer(insert, " ");

            int n = Integer.parseInt(st.nextToken());
            int [] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    result = result + gcd(arr[i], arr[j]);
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

// 값을 이렇게 복잡하게 받는 경우엔 이렇게 하면 된다 동적인 값을 받아서 여러개의 수의 gcd 를 구하기 위해서 arr을 만들어서 이중 for문으로 구현했다
// 누적된 최대공약수를 계속 더하는 구조기 때문에 int로 했다가 틀렸다 값이 크다 싶으면 long을 쓰도록하자
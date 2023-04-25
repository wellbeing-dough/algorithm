package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] erase = new boolean[1000001];
        Arrays.fill(erase, false);
        erase[0] = true;
        erase[1] = true;

        for(int i = 2; i * i <= 1000000; i++) {    //에라토스테네스의 채
            if(erase[i] == false) {
                for(int j = i + i; j <= 1000000; j = j + i) {
                    erase[j] = true;
                }
            }
        }

        int num = Integer.parseInt(bf.readLine());
        while(num != 0) {

            int a = 0, b = 0;
            boolean result = false;

            for(int i = 3; i < num; i++) {
                if(erase[i] == false) {
                    a = i;
                    b = num - a;
                    if(erase[b] == false) {
                        sb.append(a + b + " = " + a + " + " + b + "\n");
                        result = true;
                        break;
                    }
                }
            }

            if(result == false) {
                sb.append("Goldbach's conjecture is wrong.");
            }
            num = Integer.parseInt(bf.readLine());
        }

        System.out.println(sb);
    }
}
// 백만 이하의 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다. 골드바흐 추측이다
// 그럼 에라토스 테네스의 채로 1000000 까지 소수를 전부 가지고 숫자 num이 주어지면 num보다 작으면서 가장 작은 소수 a 구하고
// num - a 하면 b 가 나올태고 그 b 까지 소수인지 검증하면 끝이다
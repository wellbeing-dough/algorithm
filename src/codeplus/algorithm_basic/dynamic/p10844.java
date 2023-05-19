package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long [][]d = new long[n+1][10]; //숫자의 길이가 i 마지막 숫자가 j인 계단 수의 개수

        for(int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0) {
                    d[i][j] = d[i-1][j+1];
                } else if (j == 9) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = d[i-1][j-1] + d[i-1][j+1];
                }
                d[i][j] %= 1000000000;
            }
        }

        long result = 0;

        for(int i = 0; i <= 9; i++) {
            result = result + d[n][i];
        }

        System.out.println(result % 1000000000);

    }
}

// 1이 9이다 0은 제외하고 1,2,3,4,5,6,7,8,9 니까
// 그럼 2는 어캐될까? 1(2), 2(1,3), 3(2,4), 4(3,5), 5(4,5), 6(5,7), 7(6,8), 8(7,9), 9(8) 이다
// 그럼 점화식은 D[i][j] = D[i-1][j-1] + D[i-1][j+1] 가 되지만 예외가 있다 마지막 숫자가 0일때는 1만올 수 있고 9일떄는 8만 올 수 있다 그래서
// if else 로 예외 처리를 해줬다
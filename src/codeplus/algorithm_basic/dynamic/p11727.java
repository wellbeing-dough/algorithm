package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] d = new int[n+2];
        d[1] = 1;
        d[2] = 3;

        for(int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + d[i-2] * 2) % 10007;
        }
        System.out.println(d[n]);
    }
}

// p11726 2 x n 타일링 문제에서 달라진건 하나다 새로 들어온게 +2칸일 경우에 가로로 2개가 들어갈 수 있지만 2x2 한칸이 들어올 수 있다
// 그럼 d[i-2] 가 두번오면 된다 점화식은 d[i-1]+d[i-2]+d[i-2] 이다 왜 i-2만 두번하냐? 두칸이 생겼으니까 그래야 2x2 가 들어올 수 있으니까
// 이해안되면 ppt보자
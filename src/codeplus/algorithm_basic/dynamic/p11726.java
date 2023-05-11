package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] d = new int[n+2]; // 2×n 직사각형을 채우는 방법의 수 나는 d[2] 까지 넣어 놓으니까 1이 들어왔을 경우를 대비해 n+2로 해둔다
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.println(d[n]);
    }
}

// 2 x n 직사각형이 있을 때, 가장 오른쪽에 타일을 놓을 수 있는 방법은 총 2가지가 있다 맨오른쪽에 새로로하나 or 맨 오른쪽 두칸에 가로로 두개
// 2xn 타일이있을때, 타일을 만들 수 있는 방법의 수를 구해야 한다. 2x1 에서는 세로 한칸 2x2 에서는 가로 두칸 + 세로 한칸 + 세로 한칸 으로 만들 수 있다.
// 2x3 은 2x1 의 타일에다가 가로 두개짜리를 넣는 방법 1개랑(세로 2개는 세로 1개를 기준으로 보기때문에 제외) 2x2 의 2개에다가 세로 한칸을 붙이는 방법 2가지
// 총 3가지가 있다. 따라서 점화식 dp[i] = dp[i-2] + dp[i-1] 에 따라서 코딩을 하면 된다.
// 그리고 10007로 나누는 나머지 때문에 고생했는데 이게 수가 엄청 많아지다 보니까 1000정도 되면 오버플로우가 난다 근데 계산을 하면서 나눠도
// 마지막에 나누는거랑 결과가 똑같다
package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11053 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        int [] d = new int[n]; //A[i]까지 수열이 있을 때, A[i]을 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이
        String insert = br.readLine();
        st = new StringTokenizer(insert, " ");
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            if(result < d[i]) {
                result = d[i];
            }
        }

        System.out.println(result);

    }
}

// 이 문제를 처음봤을때 그냥 전 숫자보다 더 크면 result++ 해주는 방식을 사용 해봤는데 그게 아니였음
// 내가 보는 수 이전에 가장 큰 숫자를 기준으로 하나씩 올려야 되기 때문에 d[] 배열을 사용해서 i, j 로 그 전에 배열을 전부 확인해야 한다
// d[j] 가 d[i] 보다 작으면서 d[j] + 1을 해도 d[i] 보다 큰거(j로 봤던거 중에 제일 큰 값) 으로 해서 j를 사용해서 본 최대값에서 1을 더해야 한다
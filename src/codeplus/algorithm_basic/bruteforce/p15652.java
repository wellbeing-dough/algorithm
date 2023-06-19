package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15652 {
    static int n, m;
    static int a[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[m + 1];

        go(1);

        System.out.println(sb);
    }

    public static void go(int index) {
        //인덱스가 마지막 위치에 도달하면 수열 출력
        if(index == m + 1) {
            for(int i = 1; i <= m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        // 1부터 ~ N개의 수를 선택
        for(int i = 1; i <= n; i++) {
            if(a[index - 1] > i) {  // 비 오름차순이여야 되서
                continue;
            }
            a[index] = i; //해당 위치에 i를 넣는다.
            go(index + 1); //위치를 1증가 시키고 재귀
        }
    }
}

// 같은 수 골라도 되니까 c배열 제거, 비 오름차순이여야 되니까 if문 추가

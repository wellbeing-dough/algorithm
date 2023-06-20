package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p15654 {
    static int n, m;
    static boolean c[]; static int a[]; static int num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        c = new boolean[n + 1];
        a = new int[m];
        num = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        go(0);
        System.out.println(sb);

    }

    private static void go(int index) {

        if(index == m) {
            for(int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {

            if(c[i] == true) {
                continue;
            }

            c[i] = true;
            a[index] = num[i];
            go(index + 1);
            c[i] = false;

        }
    }
}

// 이거는 n과m 시리즈에서 그냥 1~n에서 n을 받고 그 n개의 숫자 중에서 리스트를 만드는 방법이다
// 그럼 num배열 만들어서 그걸 오름차순으로 정렬한 다음 a[index] = i 에서 a[index] = num[i] 로 하면 된다
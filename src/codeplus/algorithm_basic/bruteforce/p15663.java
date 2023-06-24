package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p15663 {
    static int n, m;
    static int a[]; static int num[]; static boolean c[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[m + 1];
        num = new int[n + 1];
        c = new boolean[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        go(1);
        System.out.println(sb);

    }

    private static void go(int index) {

        if(index == m + 1) {
            for(int i = 1; i <= m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for(int i = 1; i <= n; i++) {
            if(c[i] == true || before == num[i]) {
                continue;
            }
            c[i] = true;
            a[index] = num[i];
            before = num[i];
            go(index + 1);
            c[i] = false;
        }
    }
}


// 1 7 9 9
//1 7
//1 9
//7 1
//7 9
//9 1
//9 7
//9 9
// 이렇게 만들어야되는데 이렇게 만들려면 같은 go(index)에 있는 for문에 i 에 대해서 그 전에 했던 a[i] 가 중복되게만 안하면된다
//1 7
//1 9
//1 9
//7 1
//7 9
//7 9
//9 1
//9 7
//9 9
//9 1
//9 7
//9 9
//원래 이거라면 1,2,3 번쨰줄에 같은 1에 대해서 9가 두번 안나오게 하는거, 9 1, 9 7, 9 9, 9 1, 9 7, 9 9 가 중복으로 나오는것 또한
// 첫번째 9에 대해서 9가 또 나오면 뒤에있는 9 1, 9 7, 9 9 가 두번 안나오게 한다 재귀인걸 잊지말고
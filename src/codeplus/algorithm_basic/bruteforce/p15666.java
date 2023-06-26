package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p15666 {
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

            if(before == num[i] || a[index - 1] > num[i]) {
                continue;
            }

            before = num[i];
            a[index] = num[i];
            go(index + 1);

        }

    }
}

//1 7 9 9
//1 1
//1 7
//1 9
//7 7
//7 9
//9 9
//p15663 에서 중복 c없에고 비 오름차순을 위한 47번째 줄에 a[index - 1] > num[i] 만 해주면 된다
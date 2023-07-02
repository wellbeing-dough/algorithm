package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p10971 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());


        int[] d = new int[n];
        int[][] w = new int[n][n];

        for(int i = 0; i < n; i++) {
            d[i] = i;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        while(true) {

            int sum = 0;
            boolean ok = true;

            for(int i = 0; i < n - 1; i++) {

                if(w[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum = sum + w[d[i]][d[i + 1]];
                }
            }
            if(ok == true && w[d[n - 1]][d[0]] != 0) {
                sum = sum + w[d[n - 1]][d[0]];

                if(result > sum) {
                    result = sum;
                }
            }
            if(next_permutation(d) == false) {
                break;
            }
        }

        System.out.println(result);
    }

    // 1 2 3 4

    public static boolean next_permutation(int[] a) {

        int i = a.length - 1;

        while(i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        if(i == 0) {
            return false;
        }

        int j = a.length - 1;

        while(a[i - 1] >= a[j]) {
            j--;
        }

        int tmp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = tmp;

        j = a.length - 1;

        while(i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }

        return true;

    }
}

// d 는 방문 순서이다 이걸 next_permutation 하면 1 2 3 4, 1 2 4 3 이런식으로 모든 방문 순서를 구할 수 있다
// 그렇게 매 next_permutation 마다 w[d[i]][d[i + 1]] 해주면 해당 방문 순서의 거리를 구할 수 있고 그중에 최소값을 출력해주면 된다
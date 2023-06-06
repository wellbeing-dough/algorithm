package codeplus.algorithm_basic.bruteforce;

import java.util.*;

public class p2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - a[i] - a[j] == 100) {
                    a[i] = 0;
                    a[j] = 0;
                    Arrays.sort(a);
                    for(int k = 2; k < 9; k++) {
                        System.out.println(a[k]);
                    }
                    return;
                }
            }
        }
    }
}

// 먼저 9명 키의 합 sum을 구해준다. 그리고 2명의 키를 sum에서 빼주고 그 뺀 키가 100이 되면 나머지 7명의 키를 오름차순으로 정렬에서 출력해주면 된다.
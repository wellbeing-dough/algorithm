package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p10972 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (next_permutation(a)) {
            for (int i=0; i<n; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
    }

    public static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) { //1. a[i - 1] < a[i]를 만족하는 가장 큰 i를 찾는다
            i -= 1;
        }

        if (i <= 0) {   // 전부 역순이면 false반환
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {    //2. j >= i 이면서 a[j] > a[i - 1] 를 만족한는 가장 큰 j를 찾는다
            j -= 1;
        }

        int temp = a[i-1];  //3. a[i - 1] 과 a[j] 를 swap
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {     //4. a[i] 부터 순열을 뒤집는다
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

}

// 만약에 순열이 7 2 3 6 5 4 1 이라면
// 1. 부터 한다 즉 순열의 마지막 수에서 끝나느 가장 긴 감소 수열을 찾는다 그러면 i = 3이 된다 3, 6 은 증가 수열이니까
// 2. 그럼 j = 5 가 된다 a[i - 1] = 3, 3의 오른쪽에 있으면서 3보다 큰 수중 가장 작은 수
// 3. a[i - 1] = 3 과 a[j] = 4 를 바꾼다 그럼 7 2 4 6 5 3 1 이 된다
// 4. a[i] 부터 순열을 뒤집는다 그럼 7 2 4 1 3 5 6 이 된다 끝!
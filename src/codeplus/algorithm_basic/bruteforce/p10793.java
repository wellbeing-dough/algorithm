package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;


public class p10793 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (before_permutation(a)) {
            for (int i = 0; i < n; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
    }

    private static boolean before_permutation(int[] a) {

        int i = a.length - 1;
        while(i > 0 && a[i - 1] <= a[i]) {  //1. a[i - 1] > a[i]를 만족하는 가장 큰 i를 찾는다
            i -= 1;
        }

        if(i <= 0) {    //전부 순서대로라면 false반환
            return false;
        }

        int j = a.length - 1;
        while(a[j] >= a[i - 1]) {   //2. a[j] < a[i - 1] 를 만족하는 가장 큰 j를 찾는다
            j -= 1;
        }

        int temp = a[i - 1];    //3. a[i - 1] 과 a[j] 를 swap
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while(i < j) {      //4. a[i]부터 순열을 뒤집는다
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
        return true;
    }
}

// p10792 는 다음 순열인데 이건 이전 순열이다 그러면 이것도 예시로 7 2 3 6 5 4 1 -> 7 2 4 1 3 5 6 이 되는 예시를 들었었는데 반대로 이거는
// 7 2 4 1 3 5 6 -> 7 2 3 6 5 4 1 을 하는 예시를 들어보겠다
// 1. 순열의 마지막 수에서 끝나는 가장 긴 증가 수열을 찾는다 그러면 i = 3 이 된다 4 1 은 감소 수열이니까
// 2. a[i - 1] = 4, 4의 오른쪽에 있으면서 4보다 작은 수 중에 제일 큰 수 -> j = 4 a[4] = 3
// 3. a[i - 1] = 4 과 a[j] = 3 를 바꾼다 그럼 7 2 3 1 4 5 6 이 된다
// 4. a[i] 부터 순열을 뒤집는다 그럼 7 2 3 6 5 4 1 이 된다 끝!

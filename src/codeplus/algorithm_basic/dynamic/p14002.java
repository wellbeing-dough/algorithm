package codeplus.algorithm_basic.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p14002 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] d = new int[n + 1]; //A[i]까지 수열이 있을 때, A[i]을 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이
        int[] v = new int[n + 1]; //역추적을 위한 배열
        String insert = br.readLine();
        st = new StringTokenizer(insert, " ");

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    v[i] = j;
                }
            }
        }

        int result = 0;
        int t = 0;
        for (int i = 0; i <= n; i++) {
            if (result < d[i]) {
                result = d[i];
                t = i;
            }
        }
        sb.append(result + "\n");

        Stack<Integer> stack = new Stack<>();
        while (t != 0) {
            stack.push(a[t]);
            t = v[t];
        }

        while(!stack.empty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}

// p11053 에서 해당 문자열a의 숫자만 출력하면 된다 근데 이걸 어캐할거냐 일단 역추적을 위한 v배열, 31번째 줄 저 코드를 넣으면
// 역추적이 가능하게 된다 그리고 최대값의 배열 위치를 t로 놔주고 t가 0이 될때까지 역추적을 한다
// 해당 a의 문자열을 stack에 넣어주고 t는 다시 v[t]로 해줘서 다음 a값으로 갈 수 있게 해준다
// 스택을 사용한 이유가 스택을 사용 안하면 10 20 30 50 이 되고 50 30 20 10 을 만들어줘야 하기 때문에 스택을 사용했다
// 참고로 역추적 방법은 모든 알고리즘에서 다 똑같다 여기선 역추적을 하게 할 수 잇는 배열을 만들어준 방식을 사용했다
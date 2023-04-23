package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int [] arr = new int[t];
        int [] result =  new int[t];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < t; i++) {
            if(stack.empty()) {
                stack.push(i);
            } else {
                while(!stack.empty() && arr[stack.peek()] < arr[i]) {
                    result[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for(int i = 0; i < t; i++) {
            sb.append(result[i] + " ");
        }
        System.out.print(sb);
    }
}

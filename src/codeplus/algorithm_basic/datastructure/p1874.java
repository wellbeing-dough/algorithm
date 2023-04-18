package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int t = Integer.parseInt(br.readLine());

        int m = 0;

        while(t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num > m) {
                while(num > m) {
                    stack.push(++m);
                    sb.append("+"+"\n");
                }
                stack.pop();
                sb.append("-"+"\n");
            }else if(num == stack.peek()) {
                stack.pop();
                sb.append("-"+"\n");
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
        br.close();

    }
}

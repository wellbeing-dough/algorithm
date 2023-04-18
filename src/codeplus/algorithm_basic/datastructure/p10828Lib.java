package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p10828Lib {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String insert = br.readLine();
            st = new StringTokenizer(insert, " ");
            String command = st.nextToken();

            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }

            else if(command.equals("pop")) {
                if(stack.empty()) {
                    sb.append("-1\n");
                }else {
                    sb.append(stack.pop() + "\n");
                }
            }

            else if(command.equals("size")) {
                sb.append(stack.size() + "\n");
            }

            else if(command.equals("empty")) {
                if(stack.empty()) {
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            }

            else if(command.equals("top")) {
                if(stack.empty()) {
                    sb.append("-1\n");
                }else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb);
    }

}

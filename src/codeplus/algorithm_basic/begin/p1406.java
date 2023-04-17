package codeplus.algorithm_basic.begin;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1406 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        String s = br.readLine();

        for(Character ch : s.toCharArray()) {
            leftStack.push(ch.toString());
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            String command = st.nextToken();

            if(command.equals("L")) {
                if(!leftStack.empty()) {
                    rightStack.push(leftStack.pop());
                }
            }else if(command.equals("D")) {
                if(!rightStack.empty()) {
                    leftStack.push(rightStack.pop());
                }
            }else if(command.equals("B")) {
                if(!leftStack.empty()) {
                    leftStack.pop();
                }
            }else if(command.equals("P")) {
                leftStack.push(st.nextToken());
            }
        }

        while(!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }

        StringBuilder sb = new StringBuilder();

        while(!rightStack.empty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
        br.close();

    }
}

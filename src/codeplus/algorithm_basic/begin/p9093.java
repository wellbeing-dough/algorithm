package codeplus.algorithm_basic.begin;

import java.io.*;
import java.util.Stack;

public class p9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String sentence = br.readLine() + "\n";
            Stack<Character> stack = new Stack<>();
            for(char ch : sentence.toCharArray()) {
                if(ch == '\n' || ch == ' ') {
                    while(!stack.empty()) {
                        sb.append(stack.pop());
//                        bw.write(stack.pop());
                    }
                    sb.append(ch);
//                    bw.write(ch);
                }else {
                    stack.push(ch);
                }
            }
        }
        System.out.println(sb);
//        bw.flush();
    }
}

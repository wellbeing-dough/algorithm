package codeplus.algorithm_basic.begin;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String sentence = br.readLine() + "\n";
            Stack<Character> stack = new Stack<Character>();
            for(char ch : sentence.toCharArray()) {
                if(ch == '\n' || ch == ' ') {
                    while(!stack.empty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(ch);
                }else {
                    stack.push(ch);
                }
            }
        }
        bw.flush();
    }
}

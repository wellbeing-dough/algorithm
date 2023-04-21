package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = bf.readLine();

        Boolean tag = false;

        for(char c : str.toCharArray()) {
            if(c == '<') {
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append('<');
                tag = true;
            } else if(c == '>') {
                sb.append('>');
                tag = false;
            } else if(tag) {
                sb.append(c);
            } else {
                if(c == ' ') {
                    while(!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}

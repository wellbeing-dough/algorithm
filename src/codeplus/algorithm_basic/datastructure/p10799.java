package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10799 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int count = 0;
        String insert = br.readLine();
        Boolean laser = false;

        for(char ch : insert.toCharArray()) {
            if(ch == '(') {
                laser = false;
                stack.push(ch);
            } else if(ch == ')') {
                stack.pop();
                if(laser == false) {
                    count += stack.size();
                    laser = true;
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

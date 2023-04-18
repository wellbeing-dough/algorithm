package codeplus.algorithm_basic.datastructure;

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
//String sentence = br.readLine() + "\n"; 끝에 줄바꿈 추가해줘야 줄이 바뀐줄 알고 다음줄 넘어가기 전에 마지막 단어 바꾸기 가능
//if(ch == '\n' || ch == ' ') 여기서 '\n' 이 있어야 다음줄 넘어가기 전에 마지막 단어 바꾸기 가능

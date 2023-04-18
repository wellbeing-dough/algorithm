package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int count = 0;
            String sentence = br.readLine();
            for(char ch : sentence.toCharArray()) {
                if(ch == '(') {
                    count++;
                }else {
                    count--;
                }
                if(count < 0) {
                    break;
                }
            }
            if(count == 0) {
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
//그냥 앞으로 while(t-- > 0) 을 쓰자 몰라 걍 외워
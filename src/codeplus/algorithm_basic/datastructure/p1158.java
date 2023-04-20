package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        sb.append("<");

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while(queue.size() != 1) {
            for(int j = 1; j < k; j++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll());
        sb.append(">");
        System.out.println(sb);
    }
}

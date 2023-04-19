package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p10845Lib {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<Integer>();

        int t = Integer.parseInt(br.readLine());

        int back = 0;

        while (t-- > 0) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                back = Integer.parseInt(st.nextToken());
                queue.offer(back);
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else if (command.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(back + "\n");
                }
            } else if (command.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(queue.peek() + "\n");
                }
            }
        }
        System.out.println(sb);
        br.close();

    }
}

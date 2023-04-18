package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10845 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int [] queue = new int[10000];

        int size = 0, front = 0, back = 0;

        int t = Integer.parseInt(bf.readLine());

        while (t-- > 0) {
            String str = bf.readLine();
            st = new StringTokenizer(str, " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                queue[back++] = value;
                size++;
            } else if (command.equals("pop")) {
                if (front == back) {
                    sb.append(-1+"\n");
                } else {
                    sb.append(queue[front++]+"\n");
                    size--;
                }
            } else if (command.equals("size")) {
                sb.append(size+"\n");
            } else if (command.equals("empty")) {
                if (front == back) {
                    sb.append(1+"\n");
                } else {
                    sb.append(0+"\n");
                }
            } else if (command.equals("back")) {
                if (front == back) {
                    sb.append(-1+"\n");
                } else {
                    sb.append(queue[back - 1]+"\n");
                }
            } else if (command.equals("front")) {
                if (front == back) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(queue[front] + "\n");
                }
            }
        }
        System.out.println(sb);
        bf.close();
    }
}

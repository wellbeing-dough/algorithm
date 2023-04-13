package codeplus.algorithm_basic.begin;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class p10828 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int top = -1;
        int [] a = new int [t];
        for(int i = 0; i < t; i++) {

            String insert = sc.next();

            if(insert.contains("push")) {
                int num = Integer.parseInt(sc.next());
                top++;
                a[top] = num;
            }

            else if(insert.equals("pop")) {
                if(top == -1) {
                    bw.write("-1\n");
                }else {
                    bw.write(a[top] + "\n");
                    top--;
                }
            }

            else if(insert.equals("size")) {
                bw.write(top + 1 + "\n");
            }

            else if(insert.equals("empty")) {
                if(top == -1) {
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }

            else if(insert.equals("top")) {
                if(top == -1) {
                    bw.write("-1\n");
                }else {
                    bw.write(a[top] + "\n");
                }
            }
        }
        bw.flush();
    }
}

package codeplus.algorithm_basic.begin;

import java.util.Scanner;

public class p10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int a, b;

        for(int i = 0; i < t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if(a > 0 && b < 10) {
                System.out.println(a + b);
            }
        }
    }
}

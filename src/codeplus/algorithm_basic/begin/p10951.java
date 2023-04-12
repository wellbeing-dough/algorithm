package codeplus.algorithm_basic.begin;

import java.util.Scanner;

public class p10951 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int a, b;

        while (sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}

// 이문제 처럼 입력이 몇개인지 주어지지 않은 경우에는 입력을 EOF까지 받으면 된다.
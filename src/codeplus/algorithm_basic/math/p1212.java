package codeplus.algorithm_basic.math;

import java.util.Scanner;

public class p1212 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] eight = {"000","001","010","011","100","101","110","111"};
        String s = sc.nextLine();
        boolean start = true;
        if (s.length() == 1 && s.charAt(0) == '0') {
            System.out.print(0);
        }
        for (int i=0; i<s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (start == true && n < 4) {
                if (n == 0) {
                    continue;
                } else if (n == 1) {
                    System.out.print("1");
                } else if (n == 2) {
                    System.out.print("10");
                } else if (n == 3) {
                    System.out.print("11");
                }
                start = false;
            } else {
                System.out.print(eight[n]);
                start = false;
            }
        }
        System.out.println();
    }
}
// 왜 int n = s.charAt(i) - '0'; 여기서 - '0'을 해줬냐 p1372 8진수 2진수와 비슷하다
// 안빼주면 해당 문자의 아스키 코드값이 들어간다 예를들어서 '3'을 int로 바꾸면 아스키 코드값으로 51이다 그걸 아스키 코드 0 인 48 을
// 빼주면 3이 나온다
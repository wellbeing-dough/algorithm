package codeplus.algorithm_basic.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1373 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String insert = br.readLine();

        int len = insert.length();

        if(len % 3 == 1) {
            System.out.print(insert.charAt(0));
        } else if(len % 3 == 2) {
            System.out.print((insert.charAt(0)-'0') * 2 + (insert.charAt(1) - '0'));
        }
        for (int i=len%3; i<len; i+=3) {
            System.out.print((insert.charAt(i)-'0')*4 + (insert.charAt(i+1)-'0')*2 + (insert.charAt(i+2)-'0'));
        }
        System.out.println();
    }
}
//*N.charAt(i) 에 '0'을 빼준 이유
//N.charAt(i)가 문자 1일 때 아스키 코드값은 49이다. 문자 0의 아스키코드값은 48이므로 숫자 1을 만들기 위해 그 둘을 빼준다.
//3개씩 끊어야 2진수에서 8진수로 변환하기 쉽다 그럼 일단 맨처음에 11001100 같은 경우에는 11/001/100 세 부분으로 나눌 수 있는데
//첫번째 부분을 미리 잘라내기 위한 if else if 문을 놓고 나머지는 3개씩 for문으로 계산해주면 된다
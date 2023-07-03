package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p1759 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] alpha = new String[c];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < c; i++) {
            alpha[i] = st.nextToken();
        }

        Arrays.sort(alpha);

        go(l, alpha, "", 0);

        System.out.println(sb);

    }

    private static void go(int n, String[] alpha, String password, int i) {

        // n = 만들어야하는 암호의 길이, alpha = 사용할 수 있는 알바펫, password = 현재까지 만든 암호, i = 사용할지 말지 결정해야 하는
        // 알파벳의 인덱스

        if(n == password.length()) {
            if(check(password) == true) {
                sb.append(password + "\n");
            }
            return;
        }

        if(i >= alpha.length) {
            return;
        }

        go(n, alpha, password + alpha[i], i + 1);
        go(n, alpha, password, i + 1);

    }

    private static boolean check(String password) {

        int ja = 0;
        int mo = 0;

        for(char s : password.toCharArray()) {

            if(s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if(mo >= 1 && ja >= 2) {
            return true;
        } else {
            return false;
        }

    }
}

// 부르트포스에 재귀가 어느정도 감히 잡힌거 같다 나머지는 뭐 그냥 password의 length가 n과 같으면 모음 자음 검증하고 출력 하는거랑
// i 가 알파벳의 길이보다 길어지면 넘어가는거 이정도이다
// 핵심은 47번째줄이랑 48번째 줄이다 일단 password + alpha[i] 로 재귀하다보면 출력이되고 그다음 줄인 48 번쨰 줄을 실행하면 passwor
// 에 추가하지 않고 다음 줄로 넘어가는 방식이다
// input 이 a t c i s w 라고 생각하고 한번 머리속으로 계산해보자
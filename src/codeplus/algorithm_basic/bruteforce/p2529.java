package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p2529 {

    static String[] arr; static boolean[] check;
    static ArrayList<String> ans = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new String[n];
        check = new boolean[10];

        for(int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        go(0, "");

        Collections.sort(ans);

        int t = ans.size();
        System.out.println(ans.get(t - 1));
        System.out.println(ans.get(0));
    }

    private static void go(int index, String num) {

        if(index == n + 1) {
            if(check(num) == true) {
                ans.add(num);
            }
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(check[i] == true) {
                continue;
            }
            check[i] = true;
            go(index + 1, num + Integer.toString(i));
            check[i] = false;
        }
    }
    private static boolean check(String num) {

        for(int i = 0; i < n; i++) {
            if(arr[i].equals(">")) {
                if(num.charAt(i) < num.charAt(i + 1)) {
                    return false;
                }
            }
            if(arr[i].equals("<")) {
                if(num.charAt(i) > num.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 일단 num은 여태까지 쌓아온 숫자 모음인데 int로 하려 했는데 그러면 213 이 정답이면 213을 하나씩 나눠서 하기 불편해서 그냥 String으로 하고
// 다음 숫자는 num + Integer.toString(i) 로 해서 부등호에 관한 숫자들을 쌓았다 그렇게 숫자가 다 쌓이면 (index == n + 1)
// check라는 함수에서 이 부등호에 알맞은지 검사한 후 true면  ans 라는 ArrayList에 num을 담고 그 알맞은 배열을 모아놓은 ans를 오름차순으로
// 정렬한 후 가장 큰 숫자와 가장 작은 숫자를 출력했다 check에서 몰랐던 점이 arr[i] == ">" 이거 안되더라
// java에서는 문자열을 == 연산자로 비교할 수 없다. 대신 equals() 메서드를 사용하여 문자열의 내용을 비교해야 한다
// 이렇게 재귀 함수로 전체 숫자들을 한번씩 해볼 수 있다 check 배열은 숫자가 중복될 수 없어서 해당 숫자가 이미 쓰였는지 확인하는거다
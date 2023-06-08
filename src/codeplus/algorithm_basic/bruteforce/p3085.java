package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3085 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char [][] arr = new char[n][n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if((j + 1 < n)) {
                    char tmp = arr[i][j + 1];
                    arr[i][j + 1] = arr[i][j];
                    arr[i][j] = tmp;
                    int result = check(arr);
                    if(ans < result) {
                        ans = result;
                    }
                    tmp = arr[i][j + 1];
                    arr[i][j + 1] = arr[i][j];
                    arr[i][j] = tmp;
                }

                if((i + 1 < n)) {
                    char tmp = arr[i + 1][j];
                    arr[i + 1][j] = arr[i][j];
                    arr[i][j] = tmp;
                    int result = check(arr);
                    if(ans < result) {
                        ans = result;
                    }
                    tmp = arr[i + 1][j];
                    arr[i + 1][j] = arr[i][j];
                    arr[i][j] = tmp;
                }
            }
        }
        System.out.println(ans);
    }

    public static int check(char [][] arr) {

        int len = arr.length;
        int ans = 0;

        for(int i = 0; i < len; i++) {
            int result = 1;
            for(int j = 0; j < len - 1; j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    result++;
                    if(result > ans) {
                        ans = result;
                    }
                } else {
                    result = 1;
                }
            }
            result = 1;
            for(int k = 0; k < len - 1; k++) {
                if (arr[k][i] == arr[k + 1][i]) {
                    result++;
                    if(result > ans) {
                        ans = result;
                    }
                } else {
                    result = 1;
                }
            }
        }
        return ans;
    }
}

// arr 한 숫자에 오른쪽과 아래에랑 바꾸고 check함수는 바뀐 arr에서 연속되는 개수를 확인하는 함수이다
// 그냥 빡구현이다
// 59번째부터 82번째줄까지 보면 왼쪽거나 아래거 숫자랑 같으면 result++ 해주고 그 숫자가 최대치로 새로 해주고
// 그게 아니라면 result 를 다시 1로 초기화해서 연속되는 숫자개수를 1로 초기화해준다
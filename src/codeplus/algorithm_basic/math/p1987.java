package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1987 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int result = 0;
        while(t-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            boolean prime = isPrime(num);
            if(prime) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// 보통은 2부터 n/2 까지의 숫자까지 나눠보며 나눠진다면 소수가 아니고 나눠지지 않는다면 소수라고 판별하는데 √n을 사용하면 시간복잡도를 크게 줄일 수 있다.
// 가령 24 의 약수를 나타내면 1,2,3,4,6,8,12,24 인데 √24(4.~~) 을 기준으로 좌우 숫자로 짝지어 진다. 4 x 6 , 3 x 8 , 2 x 12 이런식으로 그렇기 때문에
// √n 까지의 숫자로 나눠진다면 소수가 아니고 나눠지지 않으면 소수이다.
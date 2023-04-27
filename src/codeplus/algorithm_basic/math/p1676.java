package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());
        int result = 0;
        for(int i = 5; i <= num; i = i * 5) {
            result = result + num/i;
        }
        System.out.println(result);
    }
}
// 팩토리얼을 구해서 0의개수를 찾는거보다 0이 들어가기 위해선 무조건 2 * 5 가 있어야 하는데 2는 엄청 많으니까 num을 인수분해해서 5를 찾으면 된다
// 5의 제곱근 마다 인수분해 하면 5의 개수가 하나씩 더 들어가기 때문에 그 개수들을 찾아서 한번 더 더해주면 된다
// int n1 = n/5; //인수로 5를 하나가지고 있는 n까지의 수
// int n2 = n/25; //인수로 5를 2개 가지고 있는 n까지의 수
// int n3 = n/125; //인수로 5를 3개 가지고 있는 n까지의 수

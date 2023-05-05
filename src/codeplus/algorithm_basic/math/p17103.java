package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean [] erase = new boolean[1000001];
        Arrays.fill(erase, false);
        erase[0] = true;
        erase[1] = true;

        for(int i = 2; i * i <= 1000000; i++) {
            if(erase[i] == false) {
                for(int j = i + i; j <= 1000000; j = j + i) {
                    erase[j] = true;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int insert = Integer.parseInt(br.readLine());
            int count = 0;
            for(int i = 2; i <= insert / 2; i++) {
                if(erase[i] == false && erase[insert - i] == false) {
                    count++;
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}

// p6588 골드바흐 추측을 확실히 하고 넘어가니 그냥 로직 몇개만 수정했다 하지만 p6588은 a + b 중 a가 가장 작은것만 구하면 되서 편했는데
// 이건 전부 구해서 숫자를 추가하는거다 그래서 중복이 될 수 있어서(3 + 5, 5 + 3) insert / 2를 했는데 i < insert / 2 라 해서 애를 좀 먹었다
package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String insert = bf.readLine();
        StringTokenizer st = new StringTokenizer(insert, " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        boolean[] erase = new boolean[second+1];    //지워져 있는지 여부
        erase[0] = true;    //0, 1은 소수가 아니기때문에 지워준다
        erase[1] = true;

        for(int i = 2; i * i <= second; i++) {  //i * i 전까지는 다 지워졌다는게 보장이 되니까 그 이후로는 안해도 된다
            if(erase[i] == true) {  //지워져 있으면 볼필요 없다
                continue;
            }
            for(int j = i + i; j <= second; j = j + i) {    //안지워져 있으면 소수기 때문에 그거에 배수를 second 값까지 지워준다
                erase[j] = true;
            }
        }

        for(int i = first; i <= second; i++) {
            if(erase[i] == false) {     //안지워져있는것들(소수) 출력
                System.out.println(i);
            }
        }
    }
}

// 에라토스테네스의 채 로 구현했다

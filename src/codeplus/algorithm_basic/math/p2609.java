package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class p2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int gcd = gcdOfEuclideanAlgorithmWithRecursion(first, second);
        int lcm = first * second / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
    public static int gcdOfNormal(int a, int b) {
        int result = 1;
        for(int i = 2; i < min(a, b); i++) {
            if(a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public static int gcdOfEuclideanAlgorithmWithRecursion(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcdOfEuclideanAlgorithmWithRecursion(b, a % b);
        }
    }

    public static int gcdOfEuclideanAlgorithm(int a, int b) {
        while(b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

//A * B = GCD * LCM 이기 때문에 최대공약수를 구했으면 A*B/최대공약수 = 최소공배수가 된다
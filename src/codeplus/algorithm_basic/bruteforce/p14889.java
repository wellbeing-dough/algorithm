package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p14889 {

    static int n; static int ans;
    static int[][] s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ans = -1;

        s = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> first = new ArrayList<>();   // 첫번째 팀 팀원
        ArrayList<Integer> second = new ArrayList<>();  // 두번쨰 팀 팀원

        int result = go(0, first, second);
        System.out.println(result);
    }

    private static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {

        if(index == n) {
            if(first.size() != n/2) {
                return -1;
            }
            if(second.size() != n/2) {
                return -1;
            }

            int t1 = 0;
            int t2 = 0;

            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    if(i == j) {
                        continue;
                    }
                    t1 += s[first.get(i)][first.get(j)];
                    t2 += s[second.get(i)][second.get(j)];
                }
            }
            int diff = Math.abs(t1 - t2);
            return diff;
        }


        first.add(index);
        int t1 = go(index + 1, first, second);
        if(ans == -1 || (t1 != -1 && ans > t1)) {
            ans = t1;
        }
        first.remove(first.size() - 1);

        second.add(index);
        int t2 = go(index + 1, first, second);
        if(ans == -1 || (t2 != -1 && ans > t2)) {
            ans = t2;
        }
        second.remove(second.size() - 1);

        return ans;

    }
}

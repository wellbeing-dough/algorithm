package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;

public class p15661 {

    static int[][] s;
    static int ans; static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        ans = -1;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        System.out.println(go(0, first, second));

    }

    private static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {

        if(index == n) {
            int t1 = 0;
            int t2 = 0;

            for(int i = 0; i < first.size(); i++) {
                for(int j = 0; j < first.size(); j++) {
                    if(i == j) {
                        continue;
                    }
                    t1 += s[first.get(i)][first.get(j)];
                }
            }
            for(int i = 0; i < second.size(); i++) {
                for(int j = 0; j < second.size(); j++) {
                    if(i == j) {
                        continue;
                    }
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

package codeplus.algorithm_basic.bruteforce;

import java.util.*;
import java.io.*;


public class p14500 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(j + 3 < m) {         //가로로 4줄
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(i + 3 < n) {         //새로로 4줄
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 1 < m && i + 1 < n) {        //정사각형
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 1 < m && i + 2 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i][j + 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i + 1 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i][j + 2];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 1 < m && i + 2 < n) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i + 1 < n) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i + 1 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i - 1 >= 0) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j + 2];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if (i + 2 < n && j - 1 >= 0) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j - 1];
                    if (ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 1 < m && i + 2 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i - 1 >= 0) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j + 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 1 < m && i + 2 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j - 1 >= 0 && i + 2 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i + 1 < n) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 1 < m && i + 2 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j - 1 >= 0 && i + 2 < n) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j - 1];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i - 1 >= 0) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i - 1][j + 1] + arr[i - 1][j + 2];
                    if(ans < tmp) {
                        ans = tmp;
                    }
                }

                if(j + 2 < m && i + 1 < n) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
                    if(ans < tmp){
                        ans = tmp;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

//설명할게 없다 그냥 코드 그 자체고 개빡구현
package simulation;

import java.io.*;
import java.util.*;

public class BJ14500 {
    static int N, M;
    static int[][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        square();
        line();
        other();
        System.out.println(ans);
    }

    private static void square() { // 정사각형
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                ans = Math.max(sum, ans);
            }
        }
    }

    private static void line() { // 일자
        for (int i = 0; i < N; i++) {
            int sum = arr[i][0] + arr[i][1] + arr[i][2] + arr[i][3];
            ans = Math.max(sum, ans);
            for (int j = 1; j < M - 3; j++) {
                sum -= arr[i][j - 1];
                sum += arr[i][j + 3];
                ans = Math.max(sum, ans);
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = arr[0][i] + arr[1][i] + arr[2][i] + arr[3][i];
            ans = Math.max(sum, ans);
            for (int j = 1; j < N - 3; j++) {
                sum -= arr[j - 1][i];
                sum += arr[j + 3][i];
                ans = Math.max(sum, ans);
            }
        }
    }

    private static void other() { // 나머지 3개의 테트로미노
        for (int i = 0; i < N - 2; i++) { // 2 * 3
            for (int j = 0; j < M; j++) {
                int sum = arr[i][j] + arr[i + 1][j] + arr[i + 2][j];
                if (j != 0) {
                    for (int k = 0; k < 3; k++) {
                        sum += arr[i + k][j - 1];
                        ans = Math.max(sum, ans);
                        sum -= arr[i + k][j - 1];
                    }
                }

                if (j != M - 1) {
                    for (int k = 0; k < 3; k++) {
                        sum += arr[i + k][j + 1];
                        ans = Math.max(sum, ans);
                        sum -= arr[i + k][j + 1];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) { // 3 * 2
            for (int j = 0; j < M - 2; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                if (i != 0) {
                    for (int k = 0; k < 3; k++) {
                        sum += arr[i - 1][j + k];
                        ans = Math.max(sum, ans);
                        sum -= arr[i - 1][j + k];
                    }
                }

                if (i != N - 1) {
                    for (int k = 0; k < 3; k++) {
                        sum += arr[i + 1][j + k];
                        ans = Math.max(sum, ans);
                        sum -= arr[i + 1][j + k];
                    }
                }
            }
        }
        /*
        1
        11  테트로미노
         1
         */
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                int sum = arr[i][j] + arr[i][j + 1];
                sum += arr[i - 1][j] + arr[i + 1][j + 1];
                ans = Math.max(sum, ans);
                sum -= arr[i - 1][j] + arr[i + 1][j + 1];

                sum += arr[i - 1][j + 1] + arr[i + 1][j];
                ans = Math.max(sum, ans);
                sum -= arr[i - 1][j + 1] + arr[i + 1][j];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                int sum = arr[i][j] + arr[i + 1][j];
                sum += arr[i][j - 1] + arr[i + 1][j + 1];
                ans = Math.max(sum, ans);
                sum -= arr[i][j - 1] + arr[i + 1][j + 1];

                sum += arr[i][j + 1] + arr[i + 1][j - 1];
                ans = Math.max(sum, ans);
                sum -= arr[i][j + 1] + arr[i + 1][j - 1];
            }
        }
    }
}
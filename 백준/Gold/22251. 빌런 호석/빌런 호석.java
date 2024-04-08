import java.io.*;
import java.util.*;

public class Main {
    static int N, K, P, X;
    static boolean[][] numbers = {{true, true, true, true, true, true, false},
                                {false, false, true, true, false, false, false},
                                {false, true, true, false, true, true, true},
                                {false, true, true, true, true, false, true},
                                {true, false, true, true, false, false, true},
                                {true, true, false, true, true, false, true},
                                {true, true, false, true, true, true, true},
                                {false, true, true, true, false, false, false},
                                {true, true, true, true, true, true, true},
                                {true, true, true, true, true, false, true}};

    static int[][] diff = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken()); // 빌딩 최대 층수
        K = Integer.parseInt(st.nextToken()); // 디스플레이 숫자 자릿수
        P = Integer.parseInt(st.nextToken()); // LED 반전 갯수
        X = Integer.parseInt(st.nextToken()); // 현재 엘리베이터 위치

        // 숫자 한 자리씩 나누는 과정
        int[] num = new int[K];
        divideNum(num, X);
        // diff[0][1] : 0 -> 1이 될 때 바꿔야 하는 LED 개수
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j++) {
                if (i != j) {
                    int cnt = 0;
                    for (int k = 0; k < 7; k++) {
                        if (numbers[i][k] != numbers[j][k]) cnt++;
                    }
                    diff[i][j] = cnt;
                }
            }
        }

        int ans = 0;
        for (int n = 1; n <= N; n++) {
            int[] temp = new int[K];
            divideNum(temp, n);
            int cnt = 0;
            for (int k = 0; k < K; k++) cnt += diff[num[k]][temp[k]];
            if (cnt <= P) ans++;
        }
        System.out.println(ans - 1); // X층 포함 -1 필요
    }

    private static void divideNum(int[] arr, int n) {
        int idx = K - 1;
        int temp = n;
        while (temp > 0) {
            arr[idx] = temp % 10;
            temp /= 10;
            idx--;
        }
    }
}
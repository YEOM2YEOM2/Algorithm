package study.may.algo_15th_test;

import java.io.*;

public class BJ9663 {
    static int N;
    static int[] row;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        row = new int[N];
        visited = new boolean[N]; // visited[idx] = 1 : 해당 인덱스 열(세로)에 퀸 존재함. & 행 중복처리
        solution(0); // 0번째부터 퀸 배치 시작
        System.out.println(ans);
    }

    private static void solution(int k) {
        if (k == N) ans++;
        else {
            for (int i = 0; i < N; i++) { // 한 행씩 채워나감, 가로 중복 x
                if (!visited[i]) {
                    row[k] = i; // 2차원 배열 기준  arr[k][i] = true 와 같은 역할
                    if (promising(k)) {
                        visited[i] = true;
                        solution(k + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    private static boolean promising(int k) {
        for (int i = 0; i < k; i++) {
            if (Math.abs(row[k] - row[i]) == k - i) return false; // 대각선 중복 처리
        }
        return true;
    }
}
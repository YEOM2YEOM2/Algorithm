package study.apr.algo_13th_test;

import java.io.*;
import java.util.*;

public class BJ18428 {
    static int N;
    static char[][] arr;
    static ArrayList<Node> teachers = new ArrayList<>();

    static boolean[][] visited;
    static boolean isPossible = false;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        arr = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().charAt(0);
                if (arr[i][j] == 'T') teachers.add(new Node(i, j));
            }
        }

        comb(0);
        System.out.println(isPossible ? "YES" : "NO");
    }

    public static void comb(int k) {
        if (isPossible) return;

        if (k == 3) {
            solution();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'X' && !visited[i][j]) { // 현재 방문한 곳 빈칸 & 방문 X
                    arr[i][j] = 'O';
                    visited[i][j] = true;
                    comb(k + 1);
                    arr[i][j] = 'X';
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void solution() {
        for (int i = 0; i < teachers.size(); i++) {
            Node teacher = teachers.get(i);
            for (int k = 0; k < 4; k++) {
                for (int mul = 1; mul < N; mul++) {
                    int ni = teacher.i + di[k] * mul;
                    int nj = teacher.j + dj[k] * mul;
                    if (0 <= ni && ni < N && 0 <= nj && nj < N) { // 유효한 인덱스
                        if (arr[ni][nj] == 'O' || arr[ni][nj] == 'T') break; // 선생님과 장애물을 만날 경우 해당 방향 탐색 중단
                        else if (arr[ni][nj] == 'S') return; // 학생을 만날 경우, 해당 배치 불가능
                    }
                }
            }
        }

        isPossible = true;
    }
}

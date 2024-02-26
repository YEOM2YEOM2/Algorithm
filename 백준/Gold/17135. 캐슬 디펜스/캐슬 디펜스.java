import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int R = 3; // 조합 mCr
    static int[][] arr;
    static int[] order; // 궁수의 x좌표를 담은 배열
    static int ans = 0;

    static class Node implements Comparable<Node> {
        int i;
        int j;
        int d; // 가중치

        public Node(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d == o.d) return this.j - o.j; // 거리가 같다면 더 왼쪽에 위치한 것으로 정렬
            return this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        order = new int[R];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);
        System.out.println(ans);
    }

    private static void comb(int k, int s) { // 15 * 14 * 13 / 6 = 455 충분히 가능함.
        if (R == k) {
            ans = Math.max(ans, solution());
        } else {
            for (int i = s; i < M; i++) {
                order[k] = i;
                comb(k + 1, i + 1);
            }
        }
    }

    private static int solution() {
        // 원본 배열 유지를 위한 복사
        int[][] arrSol = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) arrSol[i][j] = arr[i][j];
        }

        int cnt = 0;
        boolean flag = true;
        while (flag) {
            List<Node> enemies = new ArrayList<>();
            for (int k = 0; k < R; k++) {
                PriorityQueue<Node> enemyCandidates = new PriorityQueue<>(); // 각 궁수가 죽일 수 있는 적 후보
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        // 적이 존재하고 적과의 거리 D 이하일 때,
                        if (arrSol[i][j] == 1) {
                            if (((N - i) + Math.abs(order[k] - j)) <= D) {
                                enemyCandidates.offer(new Node(i, j, (N - i) + Math.abs(order[k] - j)));
                            }
                        }
                    }
                }

                if (!enemyCandidates.isEmpty()) {
                    Node node = enemyCandidates.poll();
                    enemies.add(node);
                }
            }

            for (Node enemy : enemies) { // 궁수, 적 제거
                if (arrSol[enemy.i][enemy.j] == 1) {
                    arrSol[enemy.i][enemy.j] = 0;
                    cnt++;
                }
            }

            boolean temp = false; // arrSol에 적이 아직 남아있어 while문을 반복해야하는지 판단
            for (int j = 0; j < M; j++) arrSol[N - 1][j] = 0;
            for (int i = N - 2; i > -1; i--) { // 적 아래로 한 칸 이동
                for (int j = 0; j < M; j++) {
                    if (arrSol[i][j] == 1) {
                        arrSol[i][j] = 0;
                        arrSol[i + 1][j] = 1;
                        temp = true;
                    }
                }
            }

            if (!temp) {
                flag = false;
            }
        }

        return cnt;
    }
}
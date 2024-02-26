package study.feb.algo_4th_simulation;

import java.io.*;
import java.util.*;

public class BJ15685 {
    static int N;
    static int[] dx = {1, 0, -1, 0};  // d : 0(→), 1(↑), 2(←), 3(↓)
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] arr = new boolean[101][101]; // true : 드래곤 커브가 있는 지역, false : 드래곤 커브가 없는 지역

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            curve(x, y, d, g);
        }
        System.out.println(check());
    }

    private static void curve(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = list.size() - 1; j > -1; j--) { // 세대가 늘어날 때마다 점의 개수도 1개씩 증가, 마지막점을 기준으로 해당 방향으로 이동해야 선이 이어지게 그릴 수 있음.
                list.add((list.get(j) + 1) % 4); // ex) 회전하는 방향 시작이 0이면 다음 방향은 1
            }
        }

        arr[y][x] = true; // 시작점 방문 처리
        for (Integer dir : list) {
            y += dy[dir];
            x += dx[dir];
            arr[y][x] = true;
        }
    }

    private static int check() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] && arr[i + 1][j] && arr[i][j + 1] && arr[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

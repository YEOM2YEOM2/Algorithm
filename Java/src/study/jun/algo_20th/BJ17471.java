package study.jun.algo_20th;

import java.io.*;
import java.util.*;

public class BJ17471 {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[] population;
    static boolean[] visited;
    static ArrayList<int []> adjL = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        population = new int[N + 1];
        adjL.add(new int[1]);

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        for (int i = 1; i <= N; i++) population[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int M = Integer.parseInt(st.nextToken());
            adjL.add(new int[M]);
            for (int j = 0; j < M; j++) {
                int e = Integer.parseInt(st.nextToken());
                adjL.get(i)[j] = e;
            }
        }

        for (int i = 1; i < N; i++) {
            visited = new boolean[N + 1];
            comb(i, 0, 1);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    // comb로 팀 구분
    private static void comb(int n, int k, int s) {
        if (k == n) {
            solution();
            return;
        }

        for (int i = s; i <= N; i++) {
            visited[i] = true;
            comb(n, k + 1, i + 1);
            visited[i] = false;
        }
    }

    private static void solution() {
        boolean[] isPossible = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                q.add(i);
                break;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                q.add(i);
                break;
            }
        }
        // 같은 선거구역으로 구분된 구역들이 연결되어있는지 확인
        while (!q.isEmpty()) {
            Integer v = q.poll();

            if (isPossible[v]) continue;
            isPossible[v] = true;

            for (Integer w : adjL.get(v)) {
                if (visited[v] == visited[w] && !isPossible[w]) q.add(w);
            }
        }
        // isPossible 중 하나라도 해당되지 않는다면 모든 구역이 구분되지 않았음. -> 함수 종료
        for (int i = 1; i <= N; i++) if (!isPossible[i]) return;

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) sum1 += population[i];
            else sum2 += population[i];
        }
        ans = Math.min(ans, Math.abs(sum1 - sum2));
    }
}
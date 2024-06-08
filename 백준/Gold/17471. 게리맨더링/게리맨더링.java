import java.io.*;
import java.util.*;

public class Main {
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

        while (!q.isEmpty()) {
            Integer v = q.poll();

            if (isPossible[v]) continue;
            isPossible[v] = true;

            for (Integer w : adjL.get(v)) {
                if (visited[v] == visited[w] && !isPossible[w]) q.add(w);
            }
        }

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
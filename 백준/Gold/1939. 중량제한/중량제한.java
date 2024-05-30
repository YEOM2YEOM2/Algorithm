import java.io.*;
import java.util.*;

// 이분 탐색 + DFS
public class Main {
    static int N, M;
    static boolean isPossible;
    static List<Info>[] adjL;
    static boolean[] visited;

    static class Info {
        int e;
        int d;

        public Info(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken()); // 섬 개수
        M = Integer.parseInt(st.nextToken()); // 다리 정보의 수
        adjL = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adjL[i] = new ArrayList<>();

        int left = 0;
        int right = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adjL[s].add(new Info(e, d));
            adjL[e].add(new Info(s, d));
            right = Math.max(right, d);
        }

        st = new StringTokenizer(br.readLine().strip());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (left + right) / 2;
            isPossible = false;
            visited = new boolean[N + 1];

            dfs(s, e, mid);
            if (isPossible) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(right);
    }

    private static void dfs(int s, int e, int limit) {
        if (s == e) {
            isPossible = true;
            return;
        }

        visited[s] = true;
        for (Info info : adjL[s]) {
            if (!visited[info.e] && limit <= info.d) dfs(info.e, e, limit);
        }
    }
}
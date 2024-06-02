import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    static class Info {
        int x;
        int cnt;

        public Info(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100_001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(N, 0));

        int ans = 0;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Info info = q.poll();

            if (info.x == K) { // 도착 지점의 경우, 최소한의 시간으로 이동할 수 있는 경우의 수 구해야하기 때문에 visited 체크 x
                min = Math.min(min, info.cnt);
                if (min == info.cnt) ans++;
                continue;
            }

            if (visited[info.x] < info.cnt) continue;
            visited[info.x] = info.cnt;

            if (info.cnt >= min) continue;

            if (0 <= info.x - 1 && info.cnt < visited[info.x - 1]) q.offer(new Info(info.x - 1, info.cnt + 1));
            if (info.x + 1 <= 100_000 && info.cnt < visited[info.x + 1]) q.offer(new Info(info.x + 1, info.cnt + 1));
            if (info.x * 2 <= 100_000 && info.cnt < visited[info.x * 2]) q.offer(new Info(info.x * 2, info.cnt + 1));
        }

        System.out.println(min);
        System.out.println(ans);
    }
}
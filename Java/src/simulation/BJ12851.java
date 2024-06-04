package simulation;

import java.io.*;
import java.util.*;

public class BJ12851 {
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
                /*
                info.cnt의 크기 순서대로 q에 입력되기 때문에 도달하기 전에 q에 들어간 것 존재할 수 있음.
                info.cnt와 min이 같은 경우에만 최소 시간으로 도착 지점에 도착한 것.
                 */
                if (min == info.cnt) ans++;
                continue;
            }

            /*
            같은 지점에 걷기로 이동한 것과 순간이동으로 간 것 다른 경우의 수
            visited[] boolean 타입 x, int 타입으로 설정하여 info.cnt가 현재 위치의 최소 이동횟수보다 많으면 q에서 새로 뽑아서 진행
             */
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
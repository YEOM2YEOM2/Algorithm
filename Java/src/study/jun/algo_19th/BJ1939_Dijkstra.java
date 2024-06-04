package study.jun.algo_19th;

/*
5 5
1 2 5
2 3 4
1 3 3
1 4 3
4 5 1
5 1

다리가 양방향 이동이 가능하기 때문에 시작 -> 도착 도달 가능, 이동한 경로 중 다리의 가장 작은 하중을 구해야 함.
 */

import java.io.*;
import java.util.*;

public class BJ1939_Dijkstra {
    static int N, M;
    static int ans;
    static Map<Integer, Map<Integer, Integer>> adjL = new HashMap<>(); // key : 출발지, value : (key : 도착지, value : 다리 하중치)

    static class Info implements Comparable<Info> {
        int e;
        int d;

        public Info(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Info o) {
            return o.d - this.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken()); // 섬 개수
        M = Integer.parseInt(st.nextToken()); // 다리 정보의 수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (adjL.containsKey(s) && adjL.get(s).containsKey(e)) { // 중복된 다리
                adjL.get(s).put(e, Math.max(adjL.get(s).get(e), d));
                adjL.get(e).put(s, Math.max(adjL.get(e).get(s), d));
            } else { // 중복된 다리 x
                if (!adjL.containsKey(s)) {
                    if (!adjL.containsKey(e)) { // s, e섬 다리 존재 x
                        adjL.put(s, new HashMap<>());
                        adjL.put(e, new HashMap<>());
                    } else adjL.put(s, new HashMap<>()); // s섬 다리 존재 x, e섬 다리 존재 o
                } else {
                    if (!adjL.containsKey(e)) adjL.put(e, new HashMap<>()); // s섬 다리 존재 o, e섬 다리 존재 x
                }
                adjL.get(s).put(e, d);
                adjL.get(e).put(s, d);
            }
        }

        st = new StringTokenizer(br.readLine().strip());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s, e);
        System.out.println(ans);
    }

    private static void dijkstra(int s, int e) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(s, Integer.MAX_VALUE));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.e == e) {
                ans = info.d;
                return;
            }

            if (visited[info.e]) continue;
            visited[info.e] = true;

            for (Map.Entry<Integer, Integer> entry : adjL.get(info.e).entrySet()) {
                if (!visited[entry.getKey()]) {
                    pq.offer(new Info(entry.getKey(), Math.min(info.d, entry.getValue())));
                }
            }
        }
    }
}
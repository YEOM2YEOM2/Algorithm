package study.jun.algo_19th;

import java.io.*;
import java.util.*;

// 메모리 초과 -> 인접 배열 x, 인접 리스트 o
public class BJ1939_MemoryOver {
    static int N, M;
    static int ans = 0;
    static int[][] adjL;

    static class Node {
        int e;
        int d;

        public Node(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken()); // 섬 개수
        M = Integer.parseInt(st.nextToken()); // 다리 정보의 수
        adjL = new int[N + 1][N + 1]; // adjM[i][j]: i번째 섬의 인접한 섬 사이 가장 가중치가 큰 다리

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adjL[s][e] = Math.max(adjL[s][e], d);
            adjL[e][s] = Math.max(adjL[e][s], d);
        }

        st = new StringTokenizer(br.readLine().strip());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            int[] order = new int[i];
            order[0] = s;
            order[i - 1] = e;
            comb(order, s, e, 1, 0);
        }

        System.out.println(ans);
    }

    private static void comb(int[] order, int s, int e, int sIdx, int k) {
        if (k == order.length - 2) {
            if (adjL[order[order.length - 2]][e] > 0) { // 도착 섬 바로 이전의 섬에서 도착 섬까지 이동 가능할 경우
                ans = Math.max(ans, solution(order));
            }
            /*
            위의 if 조건에 해당되지 않더라도 현재 이동 경로로는 도착 섬까지 이동할 수 없음을 의미
            -> 다른 경로 탐색해야하기 때문에 return;
             */
            return;
        }

        for (int i = sIdx; i <= N; i++) {
            if (i != s && i != e && adjL[order[k]][i] > 0) { // 인접한 섬 & 방문 x
                order[k + 1] = i;
                comb(order, s, e, i + 1, k + 1);
            }
        }
    }
    private static int solution(int[] order) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < order.length; i++) {
            min = Math.min(min, adjL[order[i - 1]][order[i]]);
        }
        return min;
    }
}
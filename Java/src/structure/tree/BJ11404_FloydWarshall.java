package structure.tree;

import java.io.*;
import java.util.*;

public class BJ11404_FloydWarshall {
    /*
    플로이드-워셜 알고리즘
    : 음수 사이클이 없는 그래프내의 각 모든 정점에서 각 모든 정점까지의 최단거리를 모두 구할 수 있는 알고리즘
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] D = new int[N + 1][N + 1];

        int INF = 10000001;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) D[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) { // 간선 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 시작 도시와 도착 도시를 연결하는 노선 한 개 이상
            D[s][e] = Math.min(D[s][e], d);
        }

        // 1번 노드부터 N번 까지 거쳐가는 경우 모두 고려
        for(int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (D[i][j] == INF) sb.append(0 + " ");
                else sb.append(D[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

package study.feb.algo_5th_tree;

import java.io.*;
import java.util.*;

public class BJ3584 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int E = N - 1;
            int[] parent = new int[N + 1];
            for (int i = 0; i < E; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N + 1];

            while (a != 0) {
                visited[a] = true;
                a = parent[a];
            }

            while (b != 0) {
                if (visited[b]) {
                    System.out.println(b);
                    break;
                }
                b = parent[b];
            }
        }
    }
}

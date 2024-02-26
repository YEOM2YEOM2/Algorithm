package study.feb.algo_5th_tree;

import java.io.*;
import java.util.*;

public class BJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[][] scores = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int top = scores[0][1]; // 서류 1등 면접 점수
            int cnt = 0;
            for (int i = 1; i < N; i++) {
                if (top < scores[i][1]) {
                    cnt++;
                    continue;
                }
                top = scores[i][1];
            }
            System.out.println(N - cnt);

        }
    }
}

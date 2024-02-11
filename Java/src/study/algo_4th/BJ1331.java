package study.algo_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1331 {
    static int N = 6;
    static boolean[][] visited = new boolean[N][N];
    static int[] di = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String tmp = st.nextToken();
        int si = tmp.charAt(0) - 'A';
        int sj = Integer.parseInt(tmp.substring(1)) - 1;
        int ci = si;
        int cj = sj;
        visited[si][sj] = true;
        for (int i = 1; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int ni = temp.charAt(0) - 'A';
            int nj = Integer.parseInt(temp.substring(1)) - 1;

            // 방문 체크
            if (visited[ni][nj]) {
                System.out.println("Invalid");
                return;
            } else {
                boolean flag = false; // 나이트 이동 배열에 해당하는 ni, nj인지 체크하는 변수
                for (int k = 0; k < 8; k++) {
                    int ti = ci + di[k];
                    int tj = cj + dj[k];

                    // 나이트의 이동 배열안에 ni, nj 값이 해당하는지 체크
                    if (ti == ni && tj == nj) {
                        flag = true;
                        visited[ni][nj] = true;
                        ci = ni;
                        cj = nj;
                         break;
                    }
                }

                // 나이트 이동 배열 내부에 존재 && 방문하지 않은 곳이 아니라면
                if (!flag) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }
        // 마지막 위치에서 처음 위치로 돌아올 수 있는지 체크
        for (int k = 0; k < 8; k++) {
            int ti = ci + di[k];
            int tj = cj + dj[k];

            // 나이트의 이동 배열안에 ni, nj 값이 해당하는지 체크
            if (ti == si && tj == sj) {
                System.out.println("Valid");
                return;
            }
        }
        System.out.println("Invalid");
    }

}

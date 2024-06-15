import java.io.*;
import java.util.*;

public class Main {
    static boolean isFind;
    static int R, C, ans;
    static boolean[][] arr;
    static int[] di = {-1, 0, 1};
    static int[] dj = {1, 1, 1};

    static class Node{
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String row = br.readLine().strip();
            for (int j = 0; j < C; j++) if (row.charAt(j) == 'x') arr[i][j] = true;
        }

        for (int i = 0; i < R; i++) {
            isFind = false;
            arr[i][0] = true;
            dfs(i, 0);
        }

        bw.write(ans + "\n"); // bw, 숫자형 -> 문자로 바꿔야 출력 가능
        bw.flush();
        bw.close();
    }

    private static void dfs(int ci, int cj) {
        if (cj == C -1) {
            isFind = true;
            ans++;
            return;
        }

        for (int k = 0; k < 3; k++) {
            int ni = ci + di[k];
            int nj = cj + dj[k];
            if (0 <= ni && ni < R && 0 <= nj && nj < C && !arr[ni][nj]) {
                arr[ni][nj] = true;
                dfs(ni, nj);
                /*
                [1] 올바르지 않은 파이프 경로 : 해당 경로에 있는 지점에서는 마지막 열까지 도달 x
                arr[ni][nj] = false로 되돌릴 필요 없음.
                [2] 올바른 파이프 경로 : 돌아가서 가능한 중복 경로 탐색 안 하게 반복문 종료 필요
                 */
                if (isFind) break;
            }
        }
    }
}
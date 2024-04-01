import java.io.*;
import java.util.*;

// 분할 정복
public class Main {
    static int N;
    static boolean[][] arr;
    static boolean[][] visited;

    static int whiteCnt, blueCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        arr = new boolean[N][N]; // true : 파란색, false : 흰색
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) arr[i][j] = true;
            }
        }

        solution(0, 0, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void solution(int si, int sj, int n) {
        boolean flag = true;
        boolean temp = arr[si][sj]; // 각 색종이의 시작 지점 색깔
        for (int i = si; i < si + n; i++) { // 가로 한 줄만 볼 경우, 바로 아랫줄이 색깔이 달라서 잘라야하는 경우 보지 못함.
            for (int j = sj; j < sj + n; j++) {
                if (arr[i][j] != temp && !visited[i][j]) {
                    flag = false;
                    solution(si, sj, n / 2);
                    solution(si, sj + n / 2, n / 2);
                    solution(si + n / 2, sj, n / 2);
                    solution(si + n / 2, sj + n / 2, n / 2);
                }
            }
        }



        if (flag) {
            if (arr[si][sj]) blueCnt++;
            else whiteCnt++;

            for (int i = si; i < si + n; i++) {
                for (int j = sj; j < sj + n; j++) visited[i][j] = true;
            }
        }
    }
}
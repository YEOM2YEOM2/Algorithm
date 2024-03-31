import java.io.*;
import java.util.*;

// 분할 정복
public class BJ2630 {
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
        for (int i = si; i < si + 1; i++) {
            for (int j = sj; j < sj + n - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ans++;
                findNum(Integer.parseInt(st.nextToken()));
                if (bingo()) {
                    System.out.println(ans);
                    return;
                }
            }
        }

    }

    private static void findNum(int temp) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == temp) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static boolean bingo() {
        int cnt = 0;

        // 가로 탐색
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        // 세로 탐색
        for (int j = 0; j < 5; j++) {
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        // 대각선 탐색
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] != 0) {
                flag1 = false;
            }
            if (arr[i][4-i] != 0) {
                flag2 = false;
            }
        }
        if (flag1) {
            cnt++;
        }
        if (flag2) {
            cnt++;
        }

        if (cnt >= 3) {
            return true;
        }
        return false;
    }
}
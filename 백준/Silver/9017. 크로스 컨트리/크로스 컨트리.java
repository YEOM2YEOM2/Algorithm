import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().strip());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().strip());
            int[] arr = new int[N];
            int[] team = new int[201];

            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                team[num]++;
            }

            int cnt = 0;
            int[][] score = new int[201][3]; // 상위 4선수 점수합, 해당 팀의 선수 몇 명 지나갔나?, 다섯번째 선수 점수
            for (int i = 0; i < N; i++) {
                if (team[arr[i]] == 6) {
                    if (score[arr[i]][1] < 4) {
                        score[arr[i]][0] += i + 1 - cnt;
                    } else if (score[arr[i]][1] == 4) score[arr[i]][2] = i + 1 - cnt;
                    score[arr[i]][1]++;
                }
                else cnt++;
            }

            int ans = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < 201; i++) {
                if (score[i][0] != 0) {
                    if (score[i][0] < min) {
                        min = score[i][0];
                        ans = i;
                    } else if (score[i][0] == min) {
                        if (score[i][2] < score[ans][2]) ans = i;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
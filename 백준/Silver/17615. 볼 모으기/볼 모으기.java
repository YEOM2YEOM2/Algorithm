import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
       /*
       1. 옮길 수 있는 볼의 색깔 1가지
       2. 한 번에 한 개씩 옮길 수 있음.
       -> 경우의 수 = 2(공의 색깔) * 2(왼쪽, 오른쪽) = 4
        */
        boolean[] arr = new boolean[N];
        String temp = br.readLine().strip();
        int redCnt = 0;
        for (int i = 0; i < N; i++) {
            if (temp.charAt(i) == 'R') {
                arr[i] = true;
                redCnt++;
            }
        }

        int cnt = 1;
        ArrayList<Integer> ballCnt = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (arr[i-1] != arr[i]) {
                ballCnt.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        ballCnt.add(cnt);

        int ans = Integer.MAX_VALUE;
        if (ballCnt.size() <= 2) { // 같은 색깔 볼만 주어지거나 이미 모아져있는 경우
            System.out.println(0);
            return;
        }
        // 빨간색, 왼쪽으로 모으기
        if (arr[0]) ans = Math.min(ans, redCnt - ballCnt.get(0));
        else ans = Math.min(ans, redCnt);
        // 빨간색, 오른쪽으로 모으기
        if (arr[N - 1]) ans = Math.min(ans, redCnt - ballCnt.get(ballCnt.size() - 1));
        else ans = Math.min(ans, redCnt);
        // 파란색, 왼쪽으로 모으기
        if (!arr[0]) ans = Math.min(ans, (N - redCnt) - ballCnt.get(0));
        else ans = Math.min(ans, N - redCnt);
        // 파란색, 오른쪽으로 모으기
        if (!arr[N - 1]) ans = Math.min(ans, (N - redCnt) - ballCnt.get(ballCnt.size() - 1));
        else ans = Math.min(ans, N - redCnt);

        System.out.println(ans);
    }
}
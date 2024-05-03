import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] scores = new int[P];
        Arrays.fill(scores, -1);

        if (N == 0) System.out.println(1);
        else {
            st = new StringTokenizer(br.readLine().strip());
            for (int i = 0; i < N; i++) scores[i] = Integer.parseInt(st.nextToken());

            int ans = 0;
            boolean flag = false; // 새로운 점수가 랭킹 리스트에 들어갔는지 판단
            if (scores[P - 1] < newScore) {
                flag = true;
                scores[P - 1] = newScore;
                Arrays.sort(scores);
            }

            for (int i = P - 1; i > -1; i--) {
                if (scores[i] == newScore) {
                    ans = P - i;
                    break;
                }
            }

            System.out.println(flag ? ans : -1);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] table = new char[N];
        String temp = br.readLine();
        for (int i = 0; i < N; i++) table[i] = temp.charAt(i);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                int start = i < K ? 0 : i - K;
                int end = i + K < N ? i + K : N - 1;
                for (int j = start; j <= end; j++) {
                    if (table[j] == 'H') {
                        cnt++;
                        table[j] = 'O';
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
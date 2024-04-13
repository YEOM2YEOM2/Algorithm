import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int temp = (int) Math.pow(2, N); // 한 변의 길이
        solution(0, 0, 0, temp); // Math.pow() : 거듭 제곱 계산, 입력 & 출력 double
    }

    private static void solution(int si, int sj, int num, int n) {
        if (n == 1) {
            System.out.println(num);
            return;
        }

        int area = n * n / 4;
        if (si <= r && r < si + n / 2) {
            if (sj <= c && c < sj + n / 2) solution(si, sj, num, n / 2); //  왼쪽 위
            else solution(si, sj + n / 2, num + area, n / 2); // 오른쪽 위
        } else {
            if (sj <= c && c < sj + n / 2) solution(si + n / 2, sj, num + 2 * area, n / 2); // 왼쪽 아래
            else solution(si + n / 2, sj + n / 2, num + 3 * area, n / 2); // 오른쪽 아래
        }
    }
}
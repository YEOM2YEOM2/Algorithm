package study.apr.algo_13th_test;

import java.io.*;

// [1] https://velog.io/@gundorit/Algorithm-%EB%B0%B1%EC%A4%80-5904-Moo-%EA%B2%8C%EC%9E%84-in-Java
public class BJ5904 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        // 초기값
        int length = 3;
        int k = 0;

        // n의 범위
        while (length < N) {
            k++;
            length = 2 * length + (k + 2 + 1); // m : 1개, o : (k+2)개
        }

        solution(length, k);
    }

    //  S[k-1]+ "m..o" + S[k-1], 세 구역으로 나눠서 탐색
    public static void solution(int length, int k) {
        // 초기, S[0] = "moo"
        if (k == 0) {
            if (N == 1) {
                System.out.println('m');
                return;
            }
            else {
                System.out.println('o');
                return;
            }
        }
        // S[k] = S[k-1] + "m..o" + S[k-1], k >= 1
        int prev = (length - (k + 2 + 1)) / 2; // "m..o" 중간 배열 제외 이전 배열 길이 구하기
        // S[k-1]
        if (N <= prev) solution(prev, k - 1);
        // "m..o"
        else if (prev < N && N <= prev + (k + 2 + 1)) {
            if (prev + 1 == N) System.out.println('m');
            else System.out.println('o');
        }
        // S[k-1]
        else {
            N -= (prev + (k + 2 + 1)); // S[k-1] 배열과 같음, N을 처음 + 중간 배열 길이 만큼 빼줌.
            solution(prev, k - 1);
        }
    }
}
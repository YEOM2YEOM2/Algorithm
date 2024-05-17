package study.may.algo_17th_test;
// https://velog.io/@chaerim1001/%EB%B0%B1%EC%A4%80-2615%EB%B2%88-%EC%98%A4%EB%AA%A9-Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2615_DFS {
    static int[][] arr = new int[19][19];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19;  i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < 19; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

    }
}
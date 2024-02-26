package study.mar.algo_6th_mst;

import java.io.*;
import java.util.*;

public class BJ6087 {
    static int W, H;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new String[H][W];

        for (int i = 0; i < H; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                arr[i][j] = temp[j];
            }
        }


    }
}

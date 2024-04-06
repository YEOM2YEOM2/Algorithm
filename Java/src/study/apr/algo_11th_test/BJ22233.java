package study.apr.algo_11th_test;

import java.io.*;
import java.util.*;

public class BJ22233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) map.put(br.readLine().strip(), 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip(), ",");

            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                if (map.containsKey(key)) map.remove(key);
            }

            System.out.println(map.size());
        }
    }
}

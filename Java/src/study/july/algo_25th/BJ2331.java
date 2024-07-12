package study.july.algo_25th;

import java.io.*;
import java.util.*;

public class BJ2331 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(A, 1);

        while (true) {
            int calc = 0;
            while (A > 0) {
                calc += Math.pow(A % 10, P);
                A -= A % 10;
                A /= 10;
            }

            if (hash.containsKey(calc)) {
                if (hash.get(calc) > 2) break;
                else hash.put(calc, hash.get(calc) + 1);
            } else {
                hash.put(calc, 1);
            }

            A = calc;
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() == 1) ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
package study.july.algo_24th;

import java.io.*;
import java.util.*;

public class BJ11652 {
    /*
    intValue() : Integer 객체에서 int형 값을 뽑아내는 메소드 = 객체에 내용 값을 정수로 변환하기 위함.
    Integer, int Value / Strinv Value
    Object -> int
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine().strip());
        HashMap<Long, Long> hash = new HashMap<>();
        hash.put(0L, 0L);
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(br.readLine().strip());
            if (hash.containsKey(n)) hash.put(n, hash.get(n) + 1);
            else hash.put(n, 1L);
        }

        long ans = 0;
        for (Map.Entry<Long, Long> entry : hash.entrySet()) {
            if (hash.get(ans).longValue() < entry.getValue().longValue()) ans = entry.getKey();
            else if (hash.get(ans).longValue() == entry.getValue().longValue()) ans = Math.min(entry.getKey(), ans);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
package study.mar.algo_6th_mst;

import java.io.*;
import java.util.*;

public class BJ1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-+", true);

        int ans = 0;
        int temp = 0;
        boolean flag = true;
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("+")) continue;
            else if (s.equals("-")) flag = false;
            else {
                if (flag) ans += Integer.parseInt(s);
                else temp += Integer.parseInt(s);
            }
        }
        System.out.println(ans - temp);
    }
}

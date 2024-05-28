package study.jun.algo_19th;

import java.io.*;
import java.util.*;

public class BJ20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().strip();

        int cnt = 0;
        for (int i = 0; i < input.length(); i++) if (input.charAt(i) == '0') cnt++;

        /*
        ex) 1010, 1 : 앞에 있는 것 자릿수에 영향, 0 : 뒤에 있는 것이 자릿수에 영향
        0 : input의 마지막 idx부터 지움.
        1 : input의 첫 idx부터 지움.
         */

        int cnt0 = 0;
        int cnt1 = 0;
        boolean[] isDeleted = new boolean[input.length()];
        // 1 지우기
        for (int i = 0; i < input.length(); i++) {
           if (input.charAt(i) == '1' && cnt1 < (input.length() - cnt) / 2) {
               isDeleted[i] = true;
               cnt1++;
           }
        }
        // 0 지우기
        for (int i = input.length() - 1; i > -1; i--) {
            if (input.charAt(i) == '0' && cnt0 < cnt / 2) {
                isDeleted[i] = true;
                cnt0++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!isDeleted[i]) sb.append(input.charAt(i));
        }
        System.out.println(sb);
    }
}
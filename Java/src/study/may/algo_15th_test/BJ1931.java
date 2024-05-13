package study.may.algo_15th_test;

import java.io.*;
import java.util.*;

public class BJ1931 {
    static class Meeting implements Comparable<Meeting> {
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.e == o.e)  return this.s - o.s;
            return this.e - o.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, e);
        }
        Arrays.sort(meetings);

        int cnt = 0;
        int finish = 0;
        for (int i = 0; i < N; i++) {
            // 현재 회의 시작 시간보다 다음 회의의 종료 시간이 느릴 경우,
            if (finish > meetings[i].s) continue;

            finish = meetings[i].e;
            cnt++;
        }
        System.out.println(cnt);
    }
}

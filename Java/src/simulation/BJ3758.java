package simulation;

import java.io.*;
import java.util.*;

public class BJ3758 {
    static class Team {
        int score;
        int cnt;
        int[] problems;
        int last;

        public Team(int score, int last) {
            this.cnt = 1;
            this.score = score;
            this.last = last;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().strip());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int myId = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine().strip());
                int id = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                if (teams[id] == null) {
                    teams[id] = new Team(s, i);
                    teams[id].problems = new int[k + 1];
                    teams[id].problems[j] = s;
                } else {
                    if (teams[id].problems[j] < s) {
                        teams[id].problems[j] = s;
                    }
                    teams[id].cnt++;
                    teams[id].last = i;
                }
            }
            // 내 팀 점수 구하기 or 정렬 기준 세워서 정렬해도 상관 x
            int cnt = 0;
            int sum = 0;
            for (int i = 0; i < k + 1; i++) sum += teams[myId].problems[i];
            for (int i = 1; i < n + 1; i++) {
                if (i == myId) continue;

                int temp = 0;
                for (int j = 1; j < k + 1; j++) temp += teams[i].problems[j];
                if (sum < temp) cnt++;
                else if (sum == temp) {
                    if (teams[i].cnt < teams[myId].cnt) cnt++;
                    else if (teams[i].cnt == teams[myId].cnt) {
                        if (teams[i].last < teams[myId].last) cnt++;
                    }
                }
            }

            System.out.println(cnt + 1);
        }
    }
}
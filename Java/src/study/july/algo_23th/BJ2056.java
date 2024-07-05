package study.july.algo_23th;

import java.io.*;
import java.util.*;
// 코드 이해하기
public class BJ2056 {
    static int N;
    static int [] time, D;
    static List<List<Integer>> map; // 인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine().strip());
        map = new ArrayList<>();
        for(int i = 0; i <= N; ++i) map.add(new ArrayList<>());

        StringTokenizer st;
        time = new int[N + 1];
        D = new int[N + 1];
        for(int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine().strip());
            time[i] = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(st.nextToken());
            for(int j = 0; j < n; ++j) {
                int taskNum = Integer.parseInt(st.nextToken());
                map.get(taskNum).add(i); // map.get(i).get(j) : i 선행작업, j 후행작업
                D[i]++;
            }
        }

        int[] res = new int[N + 1]; // 해당 작업을 수행하기까지 걸리는 시간
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; ++i) {
            res[i] = time[i]; // 각 작업, 자기의 작업까지 수행하기 위해서 자신의 작업시간이 최소 시간
            if(D[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : map.get(cur)) {
                D[next]--; // 해당 작업을 수행하기 위해 선행되어야 하는 작업의 수 감소
                res[next] = Math.max(res[next], res[cur] + time[next]); // 후행 작업 시간 & 선행 작업 시간 + 후행 작업 시간 비교
                if(D[next] == 0) q.add(next);
            }
        }

        int ans = 0;
        for(int t : res) if(ans < t) ans = t;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
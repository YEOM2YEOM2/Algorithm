import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int [] time,cnt;
    static List<List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine().strip());
        map = new ArrayList<>();
        for(int i = 0; i <= N; ++i) map.add(new ArrayList<>());

        StringTokenizer st;
        time = new int[N + 1];
        cnt = new int[N + 1];
        for(int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine().strip());
            time[i] = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(st.nextToken());
            for(int j = 0; j < n; ++j) {
                int taskNum = Integer.parseInt(st.nextToken());
                map.get(taskNum).add(i);
                cnt[i]++;
            }
        }

        int[] res = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; ++i)
        {
            res[i] = time[i];
            if(cnt[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : map.get(cur)) {
                cnt[next]--;
                res[next] = Math.max(res[next],res[cur]+time[next]);

                if(cnt[next] == 0) q.add(next);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i : res) if(ans < i) ans = i;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
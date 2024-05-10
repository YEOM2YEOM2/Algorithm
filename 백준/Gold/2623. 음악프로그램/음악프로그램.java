import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();
        int[] D = new int[N + 1];
        // adjL 가수 수만큼 빈 ArrayList 형성
        for (int i = 0; i <= N; i++) adjL.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) {
                int e = Integer.parseInt(st.nextToken());
                adjL.get(s).add(e);
                D[e]++;
                s = e;
            }
        }

        System.out.println(topologicalSort(adjL, D, N));
    }
    // 위상 정렬
    private static String topologicalSort(ArrayList<ArrayList<Integer>> adjL, int[] D, int N) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int c = q.poll();
            ans.add(c);

            for (Integer n : adjL.get(c)) {
                D[n]--;

                if (D[n] == 0) q.offer(n);
            }
        }

        if (ans.size() != N) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans.get(i) + "\n");
        }
        return sb.toString();
    }
}
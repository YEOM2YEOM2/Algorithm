import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip(), ".");
            String file = new String();
            for (int j = 0; j < 2; j++) file = st.nextToken();

            if (hash.containsKey(file)) hash.put(file, hash.get(file) + 1);
            else hash.put(file, 1);
        }

        String[] ans = new String[hash.size()];
        int idx = 0;
        for (String s : hash.keySet()) {
            ans[idx] = s;
            idx++;
        }

        Arrays.sort(ans);
        for (int i = 0; i < hash.size(); i++) bw.write(ans[i] + " " + hash.get(ans[i]) + "\n");
        bw.flush();
        bw.close();
    }
}
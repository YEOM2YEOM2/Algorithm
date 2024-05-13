package structure.hash;

import java.io.*;
import java.util.*;

public class BJ25757 {
    static char option;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        option = st.nextToken().charAt(0);
        HashSet<String> users = new HashSet<>();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            String temp = br.readLine().strip();
            if (!users.contains(temp)) {
                users.add(temp);
                cnt++;
            }

            if (isOk()) {
                cnt = 0;
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean isOk() {
        if (option == 'Y') {
            if (cnt == 1) return true;
        } else if (option == 'F') {
            if (cnt == 2) return true;
        } else if (option == 'O') {
            if (cnt == 3) return true;
        }
        return false;
    }
}
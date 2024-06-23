import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr.add(0);
        arr.add(L);

        st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < N; i++) arr.add(Integer.parseInt(st.nextToken()));
        Collections.sort(arr);

        int left = 1;
        int right = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
                // 새로운 주유소를 설치할 수 있는 곳은 현재 인덱스와 다음 인덱스를 제외한 부분이기 때문에 -1 필요
                cnt += (arr.get(i + 1) - arr.get(i) - 1) / mid;
            }

            if (cnt > M) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }
}
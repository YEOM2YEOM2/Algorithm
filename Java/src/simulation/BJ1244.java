package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int[] switches = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < total; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int temp = number - 1;

            // 남학생 1, 여학생 2
            if (gender == 1) {
                for (int j = temp; j < total; j += number) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            } else {
                switches[temp] = switches[temp] == 0 ? 1 : 0;
                for (int j = 1; j < total / 2; j++) {
                    // index 넘어가면 종료
                    if (temp - j < 0 || temp + j >= total) {
                        break;
                    }

                    if (switches[temp - j] == switches[temp + j]) {
                        switches[temp - j] = switches[temp - j] == 0 ? 1: 0;
                        switches[temp + j] = switches[temp + j] == 0 ? 1: 0;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < total; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static class BJ8393 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            System.out.println(N * (N + 1) / 2);
        }
    }
}

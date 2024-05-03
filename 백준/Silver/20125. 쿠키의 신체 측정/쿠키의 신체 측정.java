import java.io.*;

public class Main {
    static int N;
    static int[] heart = new int[2];
    static int[] back = new int[2];
    static char[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        arr = new char[N][N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().strip().split("");
            for (int j = 0; j < N; j++) arr[i][j] = temp[j].charAt(0);
        }

        findHead();
        findArm();
        findBack();
        findLeg();
        System.out.println(sb);
    }

    private static void findHead() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*') {
                    sb.append((i + 2) + " " + (j + 1) + "\n");
                    heart[0] = i + 1;
                    heart[1] = j;
                    back[1] = j;
                    return;
                }
            }
        }
    }

    private static void findArm() {
        int length = 0;
        for (int j = 0; j < heart[1]; j++) {
            if (arr[heart[0]][j] == '*') length++;
        }
        sb.append(length + " ");

        length = 0;
        for (int j = heart[1] + 1; j < N; j++) {
            if (arr[heart[0]][j] == '*') length++;
        }
        sb.append(length + " ");
    }

    private static void findBack() {
        int length = 0;
        for (int i = heart[0] + 1; i < N; i++) {
            if (arr[i][heart[1]] == '*') {
                length++;
                back[0] = i;
            }
        }
        sb.append(length + " ");
    }

    private static void findLeg() {
        int length = 0;
        for (int i = back[0] + 1; i < N; i++) {
            if (arr[i][back[1] - 1] == '*') length++;
        }
        sb.append(length + " ");

        length = 0;
        for (int i = back[0] + 1; i < N; i++) {
            if (arr[i][back[1] + 1] == '*') length++;
        }
        sb.append(length);
    }
}
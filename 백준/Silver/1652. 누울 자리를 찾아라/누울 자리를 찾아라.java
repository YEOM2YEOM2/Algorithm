import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().strip());
        boolean[][] arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine().strip();
            for (int j = 0; j < N; j++) if (row.charAt(j) == '.') arr[i][j] = true;
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < N; i++) {
            int rowCnt = 0;
            int colCnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j]) rowCnt++;
                else {
                    if (rowCnt >= 2) row++;
                    rowCnt = 0;
                }

                if (arr[j][i]) colCnt++;
                else {
                    if (colCnt >= 2) col++;
                    colCnt = 0;
                }
            }

            if (rowCnt >= 2) row++;
            if (colCnt >= 2) col++;
        }

        bw.write(row + " " + col);
        bw.flush();
        bw.close();
    }
}
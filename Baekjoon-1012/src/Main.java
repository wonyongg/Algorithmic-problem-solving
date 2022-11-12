// 1012 유기농 배추
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int M;
    static int N;
    static int K;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int[][] field;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 1; T >= i; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 1; K >= j; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                field[X][Y] = 1;
            }

            for (int k = 0; M > k; k++) {
                for (int l = 0; N > l; l++) {
                    if (!visited[k][l] && field[k][l] == 1) {
                        isValid(k,l);
                        result++;
                    }
                }
            }
            bw.write(result + "\n");
            result = 0;
        }

        bw.flush();
        bw.close();
    }

    static void isValid(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; 3 >= i; i++) {
            if (x + dirX[i] >= 0 && y + dirY[i] >= 0 && x + dirX[i] < M && y + dirY[i] < N) {
                if (!visited[x + dirX[i]][y +dirY[i]] && field[x + dirX[i]][y + dirY[i]] == 1){
                    isValid(x + dirX[i], y + dirY[i]);
                }
            }
        }
    }
}
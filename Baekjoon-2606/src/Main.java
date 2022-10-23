//2606 바이러스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int computers;    // 컴퓨터의 수
    static int line;    // 간선의 수

    static int[][] arr;    // 인접 행렬로 표현
    static boolean[] check;    // 감염 확인
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computers = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[computers + 1][computers + 1];    // 1부터 표현하기 위해 인덱스 값 0 무시
        check = new boolean[computers+1]; // 1부터 표현하기 위해 인덱스 값 0 무시

        // 간선의 수 만큼 간선을 받아 노드 간 연결 여부 체크
        for (int i = 1; line >= i; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1; // 연결이 곧 감염이기 때문에 방향 상관없이 모두 체크
            arr[y][x] = 1; // 값을 넣지 않은 부분은 0으로 초기화되었음
        }

        dfs(1);
        System.out.println(count-1); // 1은 숙주이므로 제외 감염시킨 수에서 제외.

    }

    /**
     * @param start = 1
     * 1부터 감염여부를 true로 할당하면서,
     * 인접행렬의 모든 간선(arr[start][i])과 감염 체크여부(!check[i])를 확인하여 카운트에 1을 더한다.
     */
    static void dfs(int start){
        check[start] = true;
        count++;

        for (int i = 1; computers >= i; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}

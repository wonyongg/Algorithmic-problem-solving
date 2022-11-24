//11724 연결요소의 개수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int[][] graph;
    static boolean[] visited; // 방문한 곳 체크
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 그래프 구현
        for (int i = 0; M > i; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1; // 무방향 그래프이기 때문
        }

        for (int i = 1; N >= i; i++) {
            if (!visited[i]) { // 방문하지 않았다면
                dfs(i); // 탐색 시작
                count++; // 연결요소 개수 카운팅
            }
        }
        System.out.println(count);
    }

    static void dfs(int x) {
        visited[x] = true;

        for (int i = 1; N >= i; i++) {
            if (graph[x][i] == 1 && !visited[i]) dfs(i);
        }
    }
}
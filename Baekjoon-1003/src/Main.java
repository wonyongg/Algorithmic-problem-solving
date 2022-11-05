// 1003 피보나치 함수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int dp[][] = new int[41][2]; // dp로 40까지의 0, 1의 개수에 맞춰 배열 생성
        dp[0][0] = 1; // fibonacci[0] = 0
        dp[1][1] = 1; // fibonacci[1] = 1

        for (int i = 2; 41 > i; i++) { // dp 배열에 0, 1의 개수 구해놓기
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int i = 0; T > i; i++) { // N을 T번 받음, 받을때마다 sb에 출력 저장해놓기
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb); // 값 출력
    }
}
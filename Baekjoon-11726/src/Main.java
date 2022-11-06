import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];


        for (int i = 1; n >= i; i++) {
            if (i == 1) dp[1] = 1;    // 2x1일 때 경우의 수 1(2x1 1개)
            else if (i == 2) dp[2] = 2;    // 2x2일 때 경우의 수 2(2x1 2개, 1x2 2개)
            else dp[i] = (dp[i-1] + dp [i-2]) % 10007;    // 2xn 타일링 점화식
            // dp[i]를 구할때마다 %10007 연산을 해야지만 오버플로우가 발생하지 않는다고 함
        }
        System.out.println(dp[n]);
    }
}
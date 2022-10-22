// 1463 1로만들기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];    // 0 ~ n까지 연산에서 사용하는 최소 횟수를 담을 배열

        dp[0] = 0; // dp[0], dp[1]은 0을 초기화한다. 0은 입력값이 아니고, 1은 연산하지 않기 때문.
        dp[1] = 0;


        // Bottom_Up 방식(상향식)
        // 2부터 n까지 올라가며,
        // 3가지 경우 수 중에서 가장 작은 값(연산의 최소 횟수)을 배열의 요소에 넣음.
        for (int i = 2; n >= i; i++) {
            // 1을 뺀 경우
            dp[i] = dp[i-1] + 1;

            // i가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            // i가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }
        System.out.println(dp[n]);
    }
}
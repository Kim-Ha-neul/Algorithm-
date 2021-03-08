import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2193 {
	static int N, ans;
	static long dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		System.out.println(dp[N]);
	}
}
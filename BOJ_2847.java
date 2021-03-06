import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2847 {
	static int N, map[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N-1; i > 0; i--) {
			while(map[i] <= map[i - 1]) {
				map[i - 1]--;
				ans++;
			}
		}
		System.out.println(ans);
	}
}

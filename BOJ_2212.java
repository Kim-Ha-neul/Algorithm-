
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2212 {
	static int N, K, map[], dist[], ans;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new int[N];
		dist = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		for (int i = 0; i < N - 1; i++) {
			dist[i] = map[i + 1] - map[i];
		}
		Arrays.sort(dist);
		for (int i = 0; i < N - K; i++) {
			ans += dist[i];
		}
		System.out.println(ans);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
	static int N, map[][], ans;

	static void dfs(int r, int c, int type) {
		if (r == N - 1 && c == N - 1) {
			//print(map);
			ans++;
			return;
		}

		// type == 0 세로면
		if (type == 0) {
			if (r + 1 < N && map[r + 1][c] == 0) {
				map[r + 1][c] = 1;
				dfs(r + 1, c, 0);
				map[r + 1][c] = 0;
			}
			if (r + 1 < N && c + 1 < N && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0) {
				map[r + 1][c] = 1;
				map[r][c + 1] = 1;
				map[r + 1][c + 1] = 1;
				dfs(r + 1, c + 1, 2);
				map[r + 1][c] = 0;
				map[r][c + 1] = 0;
				map[r + 1][c + 1] = 0;
			}
		} else if (type == 1) { // 가로면
			if (c + 1 < N && map[r][c + 1] == 0) {
				map[r][c + 1] = 1;
				dfs(r, c + 1, 1);
				map[r][c + 1] = 0;
			}
			if (r + 1 < N && c + 1 < N && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0) {
				map[r + 1][c] = 1;
				map[r][c + 1] = 0;
				map[r + 1][c + 1] = 1;
				dfs(r + 1, c + 1, 2);
				map[r + 1][c] = 0;
				map[r][c + 1] = 0;
				map[r + 1][c + 1] = 0;
			}
		} else if (type == 2) { // 대각이면
			if (r + 1 < N && map[r + 1][c] == 0) {
				map[r + 1][c] = 1;
				dfs(r + 1, c, 0);
				map[r + 1][c] = 0;
			}
			if (c + 1 < N && map[r][c + 1] == 0) {
				map[r][c + 1] = 1;
				dfs(r, c + 1, 1);
				map[r][c + 1] = 0;
			}
			if (r + 1 < N && c + 1 < N && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0) {
				map[r + 1][c] = 1;
				map[r][c + 1] = 1;
				map[r + 1][c + 1] = 1;
				dfs(r + 1, c + 1, 2);
				map[r + 1][c] = 0;
				map[r][c + 1] = 0;
				map[r + 1][c + 1] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // input N
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 1);
		System.out.println(ans);
	}

	static void print(int map[][]) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
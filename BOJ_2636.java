import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int R, C;
	static int map[][];
	static int chkmap[][];
	static boolean visited[][];

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new int[R + 2][C + 2];
		chkmap = new int[R + 2][C + 2];
		visited = new boolean[R + 2][C + 2];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				chkmap[i][j] = map[i][j];
			}
		}
		int cnt = 0;
		int ans = 0;
		while (true) {
			boolean end = true;
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if(map[i][j] == 1)
						end = false;
				}
			}
			if(end)
				break;

			visited = new boolean[R + 2][C + 2];
			Queue<Point> queue = new LinkedList<>();
			queue.offer(new Point(0, 0));
			visited[0][0] = true;
			map[0][0] = 2;
			chkmap[0][0] = 2;
			while (!queue.isEmpty()) {
				Point np = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = np.r + dr[d];
					int nc = np.c + dc[d];

					if (nr < 0 || nc < 0 || nr > R + 1 || nc > C + 1)
						continue;
					if (visited[nr][nc])
						continue;

					if (map[nr][nc] == 0 || map[nr][nc] == 2) {
						visited[nr][nc] = true;
						queue.offer(new Point(nr, nc));
						map[nr][nc] = 2;
						chkmap[nr][nc] = 2;
					}
				}
			}
			cnt = 0;
			for (int i = 0; i <= R + 1; i++) {
				for (int j = 0; j <= C + 1; j++) {
					if (map[i][j] == 2) {
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];

							if (nr < 0 || nc < 0 || nr > R + 1 || nc > C + 1)
								continue;

							if (map[nr][nc] == 1) {
								chkmap[nr][nc] = 2;
							}
						}
					}
					if(map[i][j] == 1)
						cnt++;
				}
			}
			for (int i = 0; i <= R + 1; i++) {
				map[i] = chkmap[i].clone();
			}
			ans++;
		}
		System.out.println(ans);
		System.out.println(cnt);
	}
}

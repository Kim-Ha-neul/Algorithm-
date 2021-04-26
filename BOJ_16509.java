import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static boolean visited[][];
	static int dr[][] = { { 0, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {0, -1, -1}, { 0, 1, 1}, { 1, 1, 1}, { 1, 1, 1}, { 0, 1, 1} };
	static int dc[][] = { { -1, -1, -1}, { 0, -1, -1}, { 0, 1, 1}, { 1, 1, 1}, { 1, 1, 1}, { 0, 1, 1}, { 0, -1, -1}, { -1, -1, -1} };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(sc.nextInt(), sc.nextInt(), 0));
		int endr = sc.nextInt();
		int endc = sc.nextInt();
		visited = new boolean[10][9];
		int ans = -1;
		while (!queue.isEmpty()) {
			Point np = queue.poll();
			if (np.r == endr && np.c == endc) {
				ans = np.cnt;
				break;
			}
			for (int d = 0; d < 8; d++) {
				boolean go = true;
				int nr = np.r;
				int nc = np.c;
				for (int i = 0; i < 2; i++) {
					nr += dr[d][i];
					nc += dc[d][i];
					if (nr < 0 || nc < 0 || nr >= 10 || nc >= 9) {
						go = false;
						break;
					}
					if(nr == endr && nc == endc) {
						go = false;
						break;
					}
				}
				if(!go)
					continue;
				nr += dr[d][2];
				nc += dc[d][2];
				if (nr < 0 || nc < 0 || nr >= 10 || nc >= 9) {
					continue;
				}
				if(visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc, np.cnt + 1));
			}
		}
		System.out.println(ans);
	}
}
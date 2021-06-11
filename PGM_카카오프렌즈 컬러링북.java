import java.util.*;
class Solution {
    class Point {
		int r, c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}


	int dr[] = { -1, 1, 0, 0 };
	int dc[] = { 0, 0, -1, 1 };
    public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];
        int[][] pp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				pp[i][j] = picture[i][j];
			}
		}

		Queue<Point> queue = new LinkedList<>();
		boolean visited[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pp[i][j] != 0) {
					int num = pp[i][j];
					pp[i][j] = 0;
					queue.add(new Point(i, j));
					visited[i][j] = true;
					int cnt = 0;
					while (!queue.isEmpty()) {
						Point np = queue.poll();
						cnt++;
						for (int d = 0; d < 4; d++) {
							int nr = np.r + dr[d];
							int nc = np.c + dc[d];
							if (nr < 0 || nc < 0 || nr >= m || nc >= n)
								continue;
							if (visited[nr][nc])
								continue;

							if (pp[nr][nc] == num) {
								queue.add(new Point(nr, nc));
								visited[nr][nc] = true;
								pp[nr][nc] = 0;
							}
						}
					}
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
				}
			}
		}

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}
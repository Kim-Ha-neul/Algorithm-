import java.util.LinkedList;
import java.util.Queue;
class Solution {
    class Point{
		int r, c, cnt;
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}		
	}
    
    public int solution(int[][] maps) {
        int answer = 0;
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        int N = maps.length;
        int M = maps[0].length;
        Queue<Point> queue = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];
        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;
        boolean end = false;
        while(!queue.isEmpty()) {
        	Point np = queue.poll();
        	if(np.r == N-1 && np.c == M-1) {
        		end = true;
        		answer = np.cnt;
        		break;
        	}
        	for (int d = 0; d < 4; d++) {
				int nr = np.r + dr[d];
				int nc = np.c + dc[d];
				
				if(nr <0 || nc<0 || nr>=N || nc >=M)
					continue;
				if(visited[nr][nc])
					continue;
				if(maps[nr][nc] == 0)
					continue;
				
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc, np.cnt + 1));
			}
        }
        if(end)
        	return answer;
        else
        	return -1;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17136 {
	static int N = 10;
	static int ans;
	static int map[][];
	static List<Point> list;
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void recur(int index, int[][] chkmap, int cnt, int[] paper) {
		if(cnt >= ans) {
			return;
		}
		if(index == list.size()) {
			//print(chkmap);
			ans = Math.min(ans, cnt);
			return;
		}
		
		//첫 좌표부터 색종이를 대입해본다 대입 가능하면 넣고
		if(chkmap[list.get(index).r][list.get(index).c] != 1) {
			//재귀로 왔던 자리가 1이 아닐 경우에는
			recur(index + 1, chkmap, cnt, paper);	//깊이만 한개 증가
		}
		//다음재귀 빠져나오면 작은거 넣고 다음 재귀
		//또재귀 재귀 재귀피펄~
		for (int i = 5; i >= 1; i--) {
			// 그 크기의 색종이가 없으면
			if(paper[i-1] >= 5) {
				continue;	// 패스
			}
			
			int nr = list.get(index).r;
			int nc = list.get(index).c;
			boolean rowchk = true;
			int rowcnt = 1;
			//행의 길이를 구하고
			for (int j = 0; j < i - 1; j++) {
				nr += 1;
				rowcnt++;
				if(nr >= N) {
					rowchk = false;
					break;
				}
				if(chkmap[nr][nc] != 1) {
					rowchk = false;
					break;
				}
			}
			if(chkmap[list.get(index).r][list.get(index).c] != 1)
				rowchk = false;
			//행의 길이를 구했다면 열의 길이를 구하고
			if(rowchk) {
				boolean colchk = true;
				out:for (int row = list.get(index).r; row < list.get(index).r + rowcnt; row++) {
					for (int col = list.get(index).c; col < list.get(index).c + rowcnt; col++) {
						if(row >= N || col >= N) {
							colchk = false;
							break out;
						}
						
						if(chkmap[row][col] != 1) { // 구한 열의 갯수만큼의 정사각형이 아님
							colchk = false;
							break out;
						}
					}
				}
				if(colchk) {	//행렬 둘다 만족 한다면
					int[][] copy = new int[N][N];
					for (int k = 0; k < N; k++) {	//복사해두고
						copy[k] = chkmap[k].clone();
					}
					
					for (int row = list.get(index).r; row < list.get(index).r + rowcnt; row++) {
						for (int col = list.get(index).c; col < list.get(index).c + rowcnt; col++) {
							copy[row][col] = 2;
						}
					}
					//print(copy);
					// 재귀
					paper[i-1]++;
					recur(index + 1, copy, getCount(paper), paper);
					paper[i-1]--;
				}
			}
		}
	}
	
	static int getCount(int[] paper) {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			cnt += paper[i];
		}
		return cnt;
	}
	
	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map2[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// start input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new Point(i, j)); //색종이의 좌표들을 기릿
				}
			}
		} // end input
		int[] paper = new int[5];
		ans = Integer.MAX_VALUE;
		recur(0, map, 0, paper);
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
}

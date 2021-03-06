import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1781 {
	static class Ramen implements Comparable<Ramen> {
		int n, d, c;

		public Ramen(int n, int d, int c) {

			this.n = n;
			this.d = d;
			this.c = c;
		}

		@Override
		public int compareTo(Ramen o) {
			if (o.c == this.c)
				return this.d - o.d;
			return o.c - this.c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Ramen[] r = new Ramen[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = new Ramen(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(r);

		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i].n + " " + r[i].d + " " + r[i].c);
		}
		System.out.println();

		int ans = 0;
		boolean b[] = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = r[i-1].d, index = i-1; j > 0; j--) {
				if(!b[j]) {
					ans += r[index].c;
					b[j] = true;
					
					break;
				}
			}
		}
		System.out.println(ans);
	}
}

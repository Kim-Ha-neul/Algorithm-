import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1002 {
	static int N, x1, y1, r1, x2, y2, r2, ans;
	static double distanse, subtract;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			distanse = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			subtract = r1 > r2 ? r1 - r2 : r2 - r1;

			if (distanse == 0 && r1 == r2)
				ans = -1;
			else if (distanse < r1 + r2 && (subtract < distanse))
				ans = 2;
			else if (distanse == r1 + r2 || distanse == subtract)
				ans = 1;
			else
				ans = 0;
			
			System.out.println(ans);
		}
	}
}

import java.util.Scanner;

public class Main {
	static int N, ans;
	static int sin[];
	static int sen[];
	static boolean visited[];
	
	static void recur(int idx, int start, int mul, int sum) {
		if(idx >= 0) {
			int result = Math.abs(mul - sum);
			ans = Math.min(ans, result);
		}
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				recur(idx + 1, i, mul * sin[i], sum + sen[i]);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sin = new int[N];
		sen = new int[N];
		visited = new boolean[N];
	
		for (int i = 0; i < N; i++) {
			sin[i] = sc.nextInt();
			sen[i] = sc.nextInt();
		}
		
		ans=987654321;
		recur(-1, 0, 1, 0);
		
		System.out.println(ans);
	}
}

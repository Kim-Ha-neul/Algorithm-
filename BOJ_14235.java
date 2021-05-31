import java.util.*;

public class Main {
	static class Present implements Comparable<Present>{
		int num;
		public Present(int num) {
			super();
			this.num = num;
		}
		public int compareTo(Present o) {
			return o.num - this.num;
		}
	}
	static int N, A, map[], ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		PriorityQueue<Present> queue = new PriorityQueue();
		for (int i = 0; i < N; i++) {
			A = sc.nextInt();
			if(A == 0) {
				if(!queue.isEmpty()) 
					ans = queue.poll().num;
				else
					ans = -1;
				System.out.println(ans);
			} else {
				for(int j = 0; j < A; j++) {
					queue.add(new Present(sc.nextInt()));
				}
			}
		}
	}
}
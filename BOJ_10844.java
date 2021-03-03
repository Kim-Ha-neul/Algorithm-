import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10844 {

	private static int N;

	public void Solution() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long[] arr = new long[10];
		// N = 1일 때 자동 완성
		Arrays.fill(arr, 1);
		arr[0] = 0;
		// 그 이상일 때
		for (int i = 2; i <= N; i++) {
			long newArr[] = new long[10];
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					newArr[j] = arr[j + 1] % 1000000000;
				else if (j == 9)
					newArr[j] = arr[j - 1] % 1000000000;
				else {
					newArr[j] = (arr[j - 1] + arr[j + 1]) % 1000000000;
				}

			}
			arr = newArr;
		}
		long sum = 0;
		for (long i : arr)
			sum += i;
		System.out.println(sum % 1000000000);
	}

	public static void main(String[] args) {
		new BOJ_10844().Solution();
	}
}
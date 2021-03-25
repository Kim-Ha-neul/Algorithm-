import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dartResult = "1T2D3D#";
		char str[] = dartResult.toCharArray();
		int index = 0;
		int ans = 0;
		int sel[] = new int[3];
		int num = Integer.MIN_VALUE;
		for (int i = 0; i < str.length; i++) {
			// 숫자면
			if(str[i] >= '0' && str[i] <= '9') {
				// 계산이 완료된경우
				if(num != Integer.MIN_VALUE) {
					sel[index] = num;
					//System.out.println("sel = " + sel[index]);
					index++;
					num = -1;					
				}
				// 10일경우
				if(i + 1 < str.length && str[i + 1] == '0') {
					num = 10;
					i++;
				} else
					num = str[i] - '0';
			}
			else if(str[i] == 'S') {	// 기호면
				num = (int)Math.pow(num, 1);
			}
			else if(str[i] == 'D') {	// 기호면
				num = (int)Math.pow(num, 2);
			}
			else if(str[i] == 'T') {	// 기호면
				num = (int)Math.pow(num, 3);
			}
			else if(str[i] == '*') {	// 기호면
				if(index > 0)
					sel[index - 1] *= 2;
				num *= 2;
			}
			else if(str[i] == '#') {	// 기호면
				num *= -1;
			}
			//System.out.println("i : " + i + " num : " + num);
		}
		sel[index] = num;
		for (int i = 0; i < 3; i++) {
			ans += sel[i];
			//System.out.println(sel[i]);
		}
		System.out.println(ans);
	}
}
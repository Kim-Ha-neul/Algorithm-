import java.util.Arrays;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        char map[][] = new char[n][n];
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = "";
			int num1 = arr1[i];
			int num2 = arr2[i];
			for (int j = n - 1; j >= 0; j--) {
				if (num1 % 2 == 1) {
					map[i][j] = '#';
				} else {
					if (map[i][j] != '#')
						map[i][j] = ' ';
				}
				if (num2 % 2 == 1) {
					map[i][j] = '#';
				} else {
					if (map[i][j] != '#')
						map[i][j] = ' ';
				}
				num1 /= 2;
				num2 /= 2;
			}
			for (int j = 0; j < n; j++) {
				answer[i] += map[i][j];
			}
		}
        return answer;
    }
}


class Solution {
       public int solution(int n) {
		int list[] = new int[100001];
		int answer = 0;
		int index = 0;
		while(n > 0) {
			list[index++] = n % 3;
			n = (int) Math.floor(n/3);
		}
		int cnt = 1;
		for(int i = index - 1; i >= 0; i--) {
			answer += list[i] * cnt;
			cnt *= 3;
		}
        return answer;
    
    }
}
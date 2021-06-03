import java.util.*;
class Solution {
    public long solution(long n) {
         long answer = 0;
        
        long m = n;
        int cnt = 1;
        while(n >= 10) {
        	cnt++;
        	n /= 10;
        }
   
        int ary[] = new int[cnt];
        for (int i = 0; i < cnt; i++) {
			ary[i] = (int)(m % 10);
			m /= 10;
		}
        Arrays.sort(ary);
        System.out.println(Arrays.toString(ary));
        long index = 1;
        for (int i = 0; i < cnt; i++) {
        	answer += ary[i] * index;
        	index *= 10;
        }
        return answer;
    }
}
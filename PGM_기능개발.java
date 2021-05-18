import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] ans = new int[speeds.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i: progresses)
        	queue.add(i);
        
        int time = 1;
        int index = 0;
        int ansindex = 0;
        int cnt = 0;
        while(!queue.isEmpty()) {
        	if(queue.peek() + speeds[index] * time >= 100) {
        		queue.poll();
        		index++;
        		cnt++;
        	} else {
        		if(cnt > 0) {
        			ans[ansindex++] = cnt;
        			cnt = 0;
        		}
        		time++;
        	}
        }
        ans[ansindex++] = cnt;
        answer = new int[ansindex];
        for (int i = 0; i < ansindex ; i++) 
			answer[i] = ans[i];
		
        return answer;
    }
}
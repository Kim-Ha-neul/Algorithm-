import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int i=0; i<scoville.length; i++){
            queue.add(scoville[i]);
        }
        if(queue.peek() >= K)
        	return 0;
        boolean end = false;
        while(!queue.isEmpty()) {
        	int num1 = queue.poll();
            if(queue.isEmpty()){
                if(num1 >= K) {
            		end = true;
            	}
        		break;
            }
        	int num2 = queue.poll();
        	if(num1 >= K) {
        		end = true;
        		break;
        	}
        		
        	int sco = num1 + num2 * 2;
        	queue.add(sco);
        	answer++;
        }
        if(end)
        	return answer;
        else
        	return -1;
    }
}
import java.util.*;

class Solution {
    char[] photo = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	String[] datas;
	int answer = 0;
	boolean[] visited = new boolean[8];
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	void recur(int idx) {
		if(idx == 8) {
			boolean chk = true;
			for(int i=0; i<datas.length; i++) {
				char per1 = datas[i].charAt(0);
				char per2 = datas[i].charAt(2);
				char giho = datas[i].charAt(3);
				int num = datas[i].charAt(4) - '0' + 1;
				
				switch (giho) {
				case '=':
					if(!(Math.abs(map.get(per1) - map.get(per2)) == num))
						chk = false;
					break;
				case '<':
					if(!(Math.abs(map.get(per1) - map.get(per2)) < num ))
						chk = false;
					break;
				case '>':
					if(!(Math.abs(map.get(per1) - map.get(per2)) > num))
						chk = false;
					break;
				default:
					break;
				}
			}
			if(chk)
				answer++;
			return;
		}
		
		for(int i=0; i<8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				map.put(photo[i], idx);
				recur(idx + 1);
				map.remove(photo[i]);
				visited[i] = false;
			}
		}
	}
	
    public int solution(int n, String[] data) {
        answer = 0;
        datas = data;
        recur(0);
        return answer;
    }
}
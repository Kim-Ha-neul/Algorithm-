import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			if (map.get(clothes[i][1]) != null) {
				int num = map.get(clothes[i][1]) + 1;
				map.put(clothes[i][1], num);
			} else
				map.put(clothes[i][1], 1);
		}
		answer = 0;
		int num = 1;

		

		for (String s : map.keySet()) {
			num *= map.get(s) + 1 ;
		}
		answer += num - 1;
		

		return answer;
    }
}
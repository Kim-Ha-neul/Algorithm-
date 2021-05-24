import java.util.*;
class Solution {
    char maps[], sel[];
	HashMap<Character, String>[] ordersmap;
	int ans, cnt;
	String ansstr;
	List<String> list;

	int calcul(char[] sel) {
		int cnt = 0;
		for (int i = 0; i < ordersmap.length; i++) {
			boolean chk = true;
			for (int j = 0; j < sel.length; j++) {
				if (!ordersmap[i].containsKey(sel[j])) {
					chk = false;
					break;
				}
			}
			if (chk) {
				cnt++;
			}
		}
		return cnt;
	}

	void nCr(int idx, int start, int N, int R) {
		if (idx == R) {
			cnt = calcul(sel);
//			System.out.println(Arrays.toString(sel));
//			System.out.println(cnt);
			if (ans < cnt) {
				ans = cnt;
				list = new ArrayList<String>();
				ansstr = "";
				for (int i = 0; i < sel.length; i++) {
					ansstr += sel[i];
				}
				list.add(ansstr);
			} else if (ans == cnt) {
				ansstr = "";
				for (int i = 0; i < sel.length; i++) {
					ansstr += sel[i];
				}
				list.add(ansstr);
			}
//			for(String s : list)
//				System.out.println(s);
			return;
		}
		for (int i = start; i < N; i++) {
			sel[idx] = maps[i];
			nCr(idx + 1, i + 1, N, R);
		}
	}

	public String[] solution(String[] orders, int[] course) {

		HashMap<Character, String> map = new HashMap<>();

		ordersmap = new HashMap[orders.length];

		for (int i = 0; i < orders.length; i++) {
			ordersmap[i] = new HashMap<>();
			for (int j = 0; j < orders[i].length(); j++) {
				map.put(orders[i].charAt(j), "1");
				ordersmap[i].put(orders[i].charAt(j), "1");
			}
		}
		int N = map.size();
		maps = new char[N];
		int index = 0;
		for (char key : map.keySet()) {
//			System.out.println(key + " " + map.get(key));
			maps[index++] = key;
		}
//		System.out.println(Arrays.toString(maps));

		String temp[] = new String[100001];
		index = 0;
		for (int i = 0; i < course.length; i++) {
			ans = 0;
			cnt = 0;
			ansstr = "";
			int R = course[i];
			sel = new char[R];
			list = new ArrayList<String>();
			nCr(0, 0, N, R);
			//System.out.println("89 : " + ans);
			if(ans > 1)
				for (String s : list)
					temp[index++] = s;
		}

		String[] answer = new String[index];
		for (int i = 0; i < index; i++) {
			answer[i] = temp[i];
		}
		Arrays.sort(answer);

		return answer;
	}
}
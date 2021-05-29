import java.util.*;
class Solution {
    class umjunsik implements Comparable<umjunsik>{
		String str;
		int index;
		public umjunsik(String str, int index) {
			super();
			this.str = str;
			this.index = index;
		}
		@Override
		public int compareTo(umjunsik o) {
			if(this.str.charAt(index) == o.str.charAt(index)) {
				return this.str.compareTo(o.str);
			}
			return Character.compare(this.str.charAt(index), o.str.charAt(index));
		}
		
	}
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
		List<umjunsik> list = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			list.add(new umjunsik(strings[i], n));
		}
		Collections.sort(list);
		for (int i = 0; i < strings.length; i++) {
			answer[i] = list.get(i).str;
		}
		return answer;
    }
}
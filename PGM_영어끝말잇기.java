import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        List<String> list = new ArrayList<>();
		int index = 1;
		int time = 0;
		char lastword = words[0].charAt(words[0].length() - 1);
		boolean end = false;
		list.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			if (list.contains(words[i])) {
				end = true;
//				System.out.println("15 : " + i);
				break;
			} else {
				if(lastword != words[i].charAt(0)) {
					end = true;
//					System.out.println("19 : " + i);
//					System.out.println(lastword);
					break;
				}
				list.add(words[i]);
				lastword = words[i].charAt(words[i].length() - 1);
				index++;
				if (index == n) {
					index = 0;
					time++;
				}
			}
		}
        
        if(end){
            answer[0] = index + 1;
            answer[1] = time + 1;
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
			
        
        return answer;
    }
}
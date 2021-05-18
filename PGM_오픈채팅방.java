import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] save = new String[record.length];
		HashMap<String, String> map = new HashMap<>();
		int index = 0;
		for (int i = 0; i < record.length; i++) {
			save[i] = "";
			String[] commend = record[i].split(" ");
			switch (commend[0]) {
			case "Enter":
				map.put(commend[1], commend[2]);
				save[index++] += commend[0] + " " + commend[1];
				break;
			case "Leave":
				save[index++] += commend[0] + " " + commend[1];
				break;
			case "Change":
				map.put(commend[1], commend[2]);
				break;
			}
		}
		String[] answer = new String[index];
		for (int i = 0; i < index; i++) {
			String[] commend = save[i].split(" ");
			answer[i] = map.get(commend[1]) + "님이 ";
			switch (commend[0]) {
			case "Enter":
				answer[i] += "들어왔습니다.";
				break;
			case "Leave":
				answer[i] += "나갔습니다.";
				break;
			}
		}
		return answer;
    }
}
class Solution {
    public String solution(String new_id) {
		String answer = "";
		// step 1.
		new_id = new_id.toLowerCase();


		// step 2.
		char str[] = new_id.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if ((str[i] >= '0' && str[i] <= '9') || (str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z') || str[i] == '-' || str[i] == '_'
					|| str[i] == '.') {
				answer += str[i];
			}
		}



		// step 3.
		str = answer.toCharArray();
		answer = "";
		for (int i = 0; i < str.length; i++) {
			if (i - 1 >= 0 && str[i - 1] == '.' && str[i] == '.')
				continue;
			answer += str[i];
		}




		// step 4.
		str = answer.toCharArray();
		answer = "";
		for (int i = 0; i < str.length; i++) {
			if ((i == 0 || i == str.length - 1) && str[i] == '.')
				continue;
			answer += str[i];
		}


		// step 5.
		if (answer.length() == 0)
			answer += "a";
		
		
		// step 6.
		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
			if(answer.charAt(14) == '.')
				answer = answer.substring(0, 14);
		}
		
		// step 7.
		if( answer.length() <= 2) {
			char last = answer.charAt(answer.length() - 1);
			for (int i = answer.length(); i < 3; i++) {
				answer += last;
			}
		}
		
		return answer;
	}
}
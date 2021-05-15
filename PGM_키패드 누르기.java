class Solution {
    public String solution(int[] numbers, String hand) {
       String answer = "";
		int phone[][] = {{},{0, 0}, {0, 1}, {0, 2},
						  {1, 0}, {1, 1}, {1, 2},
						  {2, 0}, {2, 1}, {2, 2},
						  {3, 0}, {3, 1}, {3, 2}};
		int lastL[] = {3, 0};
		int lastR[] = {3, 2};
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				if(numbers[i] == 1)
					lastL = phone[1];
				if(numbers[i] == 4)
					lastL = phone[4];
				if(numbers[i] == 7)
					lastL = phone[7];
			}
			else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				if(numbers[i] == 3)
					lastR = phone[3];
				if(numbers[i] == 6)
					lastR = phone[6];
				if(numbers[i] == 9)
					lastR = phone[9];
			}
				
			else {
				int temp[] = null;
				if( numbers[i] == 2 )
					temp = phone[2];
				else if( numbers[i] == 5 )
					temp = phone[5];
				else if( numbers[i] == 8 )
					temp = phone[8];
				else if( numbers[i] == 0 )
					temp = phone[11];
				int distL = Math.abs(lastL[0] - temp[0]) + Math.abs(lastL[1] - temp[1]);
				int distR = Math.abs(lastR[0] - temp[0]) + Math.abs(lastR[1] - temp[1]);
				System.out.println(numbers[i] + " " + distL + " " + distR);
				
				if(distL > distR) {
					lastR = temp;
					answer += "R";
				} else if(distL < distR) {
					lastL = temp;
					answer += "L";
				} else {
					if(hand.equals("left")) {
						answer += "L";
						lastL = temp;
					} else {
						answer += "R";
						lastR = temp;
					}
				}
			}
		}
		return answer;
    }
}
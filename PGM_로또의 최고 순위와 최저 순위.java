class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int cnt = 0;
        int ncnt = 0;
        for(int i=0; i<6; i++){
        	if(lottos[i] == 0){
                cnt++;
            }
        	else
        		for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                    ncnt++;
                    break;
                }
            }
        }
        answer[0] = 7 - cnt;
        answer[0] = answer[0] != 7 ? answer[0] : 6;
        answer[1] = 7 - ncnt;
        answer[1] = answer[1] != 7 ? answer[1] : 6;
        return answer;
    }
}
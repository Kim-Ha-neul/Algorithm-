class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++){
            boolean chk = true;
            int num = (int) Math.sqrt(i);
            for(int j=2; j<=num; j++){
                if( i % j == 0){
                    chk = false;
                    break;
                }
            }
            if(chk)
                answer++;
        }
        return answer;
    }
}
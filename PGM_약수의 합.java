class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i < n/2 + 1; i++){
            if(n % i == 0)
                answer += i;
        }
        if(n != 0){
            answer += 1;
            if(n != 1)
                answer += n;
        }
        
        return answer;
    }
}
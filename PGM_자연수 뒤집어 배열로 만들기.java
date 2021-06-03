class Solution {
    public int[] solution(long n) {
        int cnt = 0;
        long m = n;
        while(m >= 10){
            cnt++;
            m /= 10;
        }
        cnt++;
        int[] answer = new int[cnt];
        int index = 0;
        while(n >= 10){
            answer[index++] = (int)( n % 10);
            n /= 10;
        }
        answer[cnt - 1] = (int) n;
        return answer;
    }
}
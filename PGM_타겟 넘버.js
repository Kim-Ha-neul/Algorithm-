class Solution {
    int ans = 0;
    int N = 0;
    public void dfs(int idx, int[] numbers, int cnt, int target){
        if(idx == N){
            if(cnt == target){
                ans++;
            }
            return;
        }
        
        dfs(idx + 1, numbers, cnt + numbers[idx], target);
        dfs(idx + 1, numbers, cnt - numbers[idx], target);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        N = numbers.length;
        dfs(0, numbers, 0, target);
        return ans;
    }
}
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                index = i;
            }
        }
        int ansindex = 0;
        for(int i=0; i<arr.length; i++){
            if(index == i)
                continue;
            answer[ansindex++] = arr[i];
        }
        if(arr.length == 1)
            return new int[]{-1};    
        return answer;
    }
}
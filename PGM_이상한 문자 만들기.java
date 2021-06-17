class Solution {
    public String solution(String s) {
        String answer = "";
        char[] c = new char[s.length()];
        c = s.toCharArray();
        int index = 0;
        for(int i=0; i<s.length(); i++){
            if(c[i] == ' '){
                index = 0;
                answer += " ";
            } else {
                if(index % 2 == 0){
                    answer += Character.toString(Character.toUpperCase(c[i]));
                } else {
                    answer += Character.toString(Character.toLowerCase(c[i]));
                }
                index++;
            }
        }
        

        return answer;
    }
}
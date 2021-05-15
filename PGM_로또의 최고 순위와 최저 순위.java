function solution(lottos, win_nums) {
    var answer = [];
    var check = 0;
    var zerocnt = 0;
    for(var i=0; i<6; i++){
        if(lottos[i] == 0){
            zerocnt++;
            continue;
        }
        for(var j=0; j<6; j++){
            if(win_nums[j] == lottos[i]){
                check++;
                break;
            }
        }
    }
    answer[0] = 7 - (check + zerocnt);
    
    answer[1] = 7 - check;
    if(answer[1] == 7)
        answer[1] = 6;
    if(check == 0 && zerocnt == 0){
        answer[0] = 6;
        answer[1] = 6;
    }
        
    return answer;
}
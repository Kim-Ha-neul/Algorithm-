function solution(array, commands) {
    var answer = [];
    
    for(let i=0; i<commands.length; i++){
        var nums = array.slice(commands[i][0] - 1, commands[i][1]);
        nums = nums.sort(function(a, b)  {
                  if(a > b) return 1;
                  if(a === b) return 0;
                  if(a < b) return -1;
                });
        answer.push(nums[commands[i][2] - 1]);
    }
    return answer;
}


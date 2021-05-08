const moe = class {
    constructor(index, sum) {
    this.index = index;
    this.sum = sum;
  }
}
function solution(answers) {
    var answer = [];
    var num1 = [1, 2, 3, 4, 5];
    var num2 = [2, 1, 2, 3, 2, 4, 2, 5];
    var num3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    var index1 = 0, index2 = 0, index3 = 0;
    var moes = [];
    for(var i = 0; i < 3; i++)
        moes[i] = new moe(i + 1, 0);
    
    for(var i = 0; i < answers.length; i++){
        if(answers[i] == num1[index1]){
            moes[0].sum++;
            
        }
        if(answers[i] == num2[index2]){
            moes[1].sum++;
            
        }
        if(answers[i] == num3[index3]){
            moes[2].sum++;
            
        }
        index1++;
        index2++;
        index3++;
        if(index1 == 5)
            index1 = 0;
        if(index2 == 8)
            index2 = 0;
        if(index3 == 10)
            index3 = 0;
    }
    var max = 0;
    for(var i = 0; i < 3; i++){
        if(max < moes[i].sum){
            max = moes[i].sum;
            answer = [];
            answer.push(moes[i].index);
        } else if ( max == moes[i].sum){
            answer.push(moes[i].index);
        }
    }
    return answer;
}

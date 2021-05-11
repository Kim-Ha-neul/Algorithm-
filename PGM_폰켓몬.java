function solution(nums) {
    var answer = 0;
    var myMap = new Map
    for(var i=0; i<nums.length; i++){
        myMap.set(nums[i], i+1);
    }
    answer = nums.length / 2;
    return answer < myMap.size ? answer : myMap.size;
}
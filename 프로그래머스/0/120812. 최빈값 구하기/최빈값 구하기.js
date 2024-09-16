function solution(array) {
    let nums = [];
    
    array.forEach((num) => {
        nums[num] = (nums[num] || 0) + 1;
    })
    
    let max = 0;
    let ans = -1;
    let dup = false;
    for (let n in nums) { // n은 index
        if (nums[n] > max) {
            max = nums[n];
            ans = Number(n);
            dup = false;
        } else if (nums[n] === max) {
            dup = true;
        }
    }
    
    if (!dup) {
        return ans;
    } else {
        return -1;
    }
}
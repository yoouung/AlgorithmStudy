function solution(n) { 
    let arr = [];
    for (let i = 1; i<= n; i++) {
        if (i % 2 !== 0) {
            arr[arr.length] = i;
        }
    }
    
    return arr;
}
function solution(numbers) {
    let sum = 0;
    for (let n of numbers) {
        sum += n;
    }
    return sum / numbers.length; 
}
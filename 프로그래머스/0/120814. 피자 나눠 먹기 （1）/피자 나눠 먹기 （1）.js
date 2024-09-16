function solution(n) {
    if (n <= 7) {
        return 1;
    } else if (n % 7 !== 0) {
        return Math.floor(n/7) + 1;
    } else {
        return n/7;
    }
}
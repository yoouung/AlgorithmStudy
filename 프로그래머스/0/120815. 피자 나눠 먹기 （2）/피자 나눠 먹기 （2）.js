function solution(n) {
    if (n <= 6 && n % 6 === 0) {
        return 1;
    } else if (n % 6 === 0) {
        return n / 6;
    } else {
        return getLCM(n, 6) / 6;
    }
}

function getGCD(a, b) {
    if (b === 0) return a;
    return getGCD(b, a % b);
}
function getLCM(a, b) {
    // 두 수의 곱을 최대공약수로 나눈 값
    return a * b / getGCD(a, b);
}
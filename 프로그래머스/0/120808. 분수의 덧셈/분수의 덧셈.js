function solution(numer1, denom1, numer2, denom2) {
    let result = [];
    result[1] = denom1 * denom2;
    result[0] = numer1 * denom2 + numer2 * denom1;
    
    function getGcd(a, b) {
      if (b === 0) return a;
      return getGcd(b, a % b);
    }

    const gcd = getGcd(result[0], result[1]);
    return [result[0] / gcd, result[1] / gcd ];
}
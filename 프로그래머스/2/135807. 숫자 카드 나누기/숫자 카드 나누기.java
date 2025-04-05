class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int n: arrayA) {
            gcdA = gcd(gcdA, n);
            if (gcdA == 1) break;
        }
        for (int n: arrayB) {
            gcdB = gcd(gcdB, n);
            if (gcdB == 1) break;
        }
        
        boolean isAValid = isValid(gcdA, arrayB);
        boolean isBValid = isValid(gcdB, arrayA);
        
        if (isAValid && isBValid) return Math.max(gcdA, gcdB);
        if (isAValid) return gcdA;
        if (isBValid) return gcdB;
        return 0;
    }
    
    static boolean isValid(int n, int[] arr) {
        for (int a: arr) {
            if (a%n == 0) return false;
        }
        return true;
    }
    
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
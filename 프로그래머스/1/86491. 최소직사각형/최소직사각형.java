class Solution {
    public int solution(int[][] sizes) {
        int smaller = Integer.MIN_VALUE;
        int bigger = Integer.MIN_VALUE;
        
        for (int[] size: sizes) {
            if (size[0] < size[1]) {
                smaller = Math.max(smaller, size[0]);
                bigger = Math.max(bigger, size[1]);
            } else {
                smaller = Math.max(smaller, size[1]);
                bigger = Math.max(bigger, size[0]);
            }
        }
        
        return smaller * bigger;
    }
}
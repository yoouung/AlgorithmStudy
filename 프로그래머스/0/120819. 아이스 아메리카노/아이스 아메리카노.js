function solution(money) {
    let ans = []
    ans[0] = Math.floor(money / 5500);
    ans[1] = money % 5500;
    return ans;
}
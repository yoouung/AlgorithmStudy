function solution(my_string) {
    const split = my_string.split("");
    const reversed = split.reverse();
    const reversedString = reversed.join("");
    return reversedString;
}
function solution(array) {
    array.sort((a, b) => a - b);
    const middleIndex = Math.floor(array.length / 2 + 1);
    console.log(array)
    return array[middleIndex-1];
}

// [1, 2, 7, 10, 11]을 array.sort()로 정렬하면 [1, 10, 11, 2, 7]
function solution(babbling) {
    let answer = 0;
    const can = ["aya", "ye", "woo", "ma"];
    
    for (let bab of babbling) {
        for (let item of can) {
            if (bab.includes(item)) {
                bab = bab.replace(item, "z");
            }
        }
        if (bab.replace(/z/g, '') === '') {
            answer++;
        }
    }
    
    return answer
}
    
    
    
    
    
    
    
    
    
    
// 예전 코드
    
//     var answer = 0;
//     const speak = ["aya", "ye", "woo", "ma"];
    
//     babbling.forEach((bab) => {
//         for (let sp of speak) {
//             if (bab.includes(sp)) {
//                 bab = bab.replace(sp, "z"); // replace 후 반환값 저장
//             }
//         }
//         if (bab.replace(/z/g, '') === '') { // 모든 z를 빈 문자열로 치환한 게 빈 문자열인지
//             answer += 1
//         }
//     });
//     return answer;
// }
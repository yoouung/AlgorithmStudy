function solution(participant, completion) {
    /*
    JavaScript Map 반복문: [key, value] 형태로 값을 얻는다.
    */
    const map = new Map();
    for (let name of participant) {
        map.set(name, (map.get(name) || 0) + 1);
    }
    for (let name of completion) {
        map.set(name, map.get(name) - 1);
    }
    
    for (let [name, count] of map) {
        if (count >= 1) {
            return name;
        }
    }
}
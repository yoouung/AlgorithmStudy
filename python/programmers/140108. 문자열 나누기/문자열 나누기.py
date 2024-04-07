def solution(s):
    result = 0
    d = {"else": 0}

    for char in s:
        if len(d) == 1:
            d[char] = 1
        else:
            if char in d:
                d[char] += 1
            else:
                d["else"] += 1


        items = list(d.items())
        if items[0][1] == items[1][1]:
            result += 1
            d = {"else": 0}
        
    
    if len(d) > 1:
        result += 1

    return result
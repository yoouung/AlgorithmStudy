def solution(t, p):
    answer = 0
    n = len(p)
    numbers = []
    for i in range(len(t)-n+1):
        numbers.append(t[i:i+n])
    for num in numbers:
        if int(num) <= int(p):
            answer += 1
    return answer
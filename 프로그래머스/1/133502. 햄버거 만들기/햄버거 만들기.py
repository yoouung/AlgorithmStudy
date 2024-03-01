def solution(ingredient):
    target = [1, 2, 3, 1]
    count = 0
    i = 0
    
    while i <= len(ingredient) - 4:
        if ingredient[i:i+4] == target:
            del ingredient[i:i+4]
            count += 1
            i = max(i - 4, 0)  # Restart
        else:
            i += 1

    return count
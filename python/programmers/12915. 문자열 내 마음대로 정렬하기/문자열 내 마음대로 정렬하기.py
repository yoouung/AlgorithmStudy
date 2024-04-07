def solution(strings, n):
    sorted_strings = sorted(strings, key=lambda x: (x[n], x)) # n번째 문자 기준 정렬
    
    return sorted_strings
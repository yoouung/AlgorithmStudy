def solution(sizes):
    # 가로/세로 구분 x, 짧은 부분/긴 부분
    # -> 각 부분의 max를 곱함
    
    width = []
    height = []
    
    for size in sizes:
        width.append(max(size[0], size[1]))
        height.append(min(size[0], size[1]))
    
    return max(width) * max(height)
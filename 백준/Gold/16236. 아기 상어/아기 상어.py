import sys
from collections import deque

input = sys.stdin.readline
matrix = []
n = int(input())
for _ in range(n):
    matrix.append(list(map(int, input().split())))

dx = [0,0,1,-1]
dy = [1,-1,0,0]
cnt = 0
x, y, size = 0, 0, 2

# 상어 위치 저장 (x, y)
for i in range(n):
    for j in range(n):
        if matrix[i][j] == 9:
            x = i
            y = j

# 가까운 먹이를 찾는 탐색 문제 -> bfs
# BFS를 사용할 시 입력으로는 현재 아기 상어의 위치를 생각할 수 있고,
# 	 출력으로는 후보 리스트를 반환 해야한다.
def bfs(x, y, size):
    distance = [[0] * n for _ in range(n)]
    visited = [[0] * n for _ in range(n)]
    # 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.

    q = deque()
    q.append((x,y))

    visited[x][y] = 1
    temp = []
    while q:
        cur_x,cur_y = q.popleft()
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                if matrix[nx][ny] <= size:
                    q.append((nx,ny))
                    visited[nx][ny] = 1
                    distance[nx][ny] = distance[cur_x][cur_y] + 1

                    if matrix[nx][ny] < size and matrix[nx][ny] != 0:
                        temp.append((nx, ny, distance[nx][ny])) 

    # 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
    return sorted(temp,key = lambda x: (-x[2],-x[0],-x[1]))


cnt = 0
result = 0

while 1:
    shark = bfs(x,y,size)
    # 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
    if len(shark) == 0:
        break
    # 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
    # 정렬한 결과를 반영해준다.
    nx, ny, dist = shark.pop()
    
    #움직이는 칸수가 곧 시간이 된다.
    result += dist
    matrix[x][y], matrix[nx][ny] = 0,0

    #상어좌표를 먹은 물고기 좌표로 옮겨준다.
    x, y = nx, ny
    
    cnt += 1
    if cnt == size:
        size += 1
        cnt = 0

print(result)
# Last updated: 6/6/2025, 3:27:23 PM
from queue import PriorityQueue
class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        m, n = len(forest), len(forest[0])
        dirs = {(0,1), (1,0), (0,-1), (-1,0)}
        if forest[0][0] == 0: return -1

        def dst(cur, nxt):
            if cur == nxt: return 0
            i, j = cur[1], cur[2]
            target_i, target_j = nxt[1], nxt[2]
            # print("i,j: ",i,"; ",j)
            q = deque([(i, j)])
            visited = set([(i, j)])
            # print("visited: ",visited)
            steps = 0
            while q:
                # print("q: ", q)
                length = len(q)
                # print(length)
                steps += 1
                for _ in range(length):
                    c = q.popleft()
                    # print("steps: ",steps, "; c: ",c, ",target_i, target_j:",target_i,"; ", target_j)
                    for dir in dirs:
                        nxt_i, nxt_j = c[0] + dir[0],c[1] + dir[1]
                        
                        if 0 <= nxt_i < m and 0 <= nxt_j < n:
                            if nxt_i == target_i and nxt_j == target_j:
                                return steps
                            if (nxt_i, nxt_j) not in visited and forest[nxt_i][nxt_j] > 0:
                                visited.add((nxt_i, nxt_j))
                                q.append((nxt_i, nxt_j))
            return -1


        pq = PriorityQueue()
        for i in range(m):
            for j in range(n):
                if forest[i][j] <= 1:
                    continue
                pq.put((forest[i][j], i, j))
        cur = (forest[0][0],0,0)
        # print(pq)
        # print("cur: ",cur)
        res = 0
        while not pq.empty():
            nxt = pq.get()
            # print("nxt: ",nxt)
            d = dst(cur, nxt)
            if d < 0:
                return -1
            res += d
            cur = nxt
        return res

# Last updated: 6/2/2025, 10:56:00 PM
class Solution:
    def maxCandies(self, status: List[int], candies: List[int], keys: List[List[int]], containedBoxes: List[List[int]], initialBoxes: List[int]) -> int:
        n = len(status)
        has_box = [False] * n
        visited = [False] * n
        can_open = status[:]
        q = deque()
        keyset, contained = set(), set()

        # initialize avaliable boxes and avaliable keys
        res = 0
        for box in initialBoxes:
            has_box[box] = True
            if status[box] == 1:
                q.append(box)
                visited[box] = True
                res += candies[box]
        # print(q)
        # print("keyset: ",keyset)
        
        while(q):
            cur_box = q.popleft()
            for key in keys[cur_box]:
                can_open[key] = True
                if not visited[key] and has_box[key]: 
                    q.append(key)
                    visited[key] = True
                    res += candies[key]
            for box in containedBoxes[cur_box]:
                has_box[box] = True
                if not visited[box] and can_open[box]:
                    q.append(box)
                    visited[box] = True
                    res += candies[box]


            
        return res 
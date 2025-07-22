# Last updated: 7/22/2025, 1:17:26 PM
class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        v1,v2 = edges[0]
        v3,v4 = edges[1]
        cnt = Counter([v1,v2,v3,v4])
        for i in list(cnt.items()):
            if i[1] == 2:
                return i[0]
        
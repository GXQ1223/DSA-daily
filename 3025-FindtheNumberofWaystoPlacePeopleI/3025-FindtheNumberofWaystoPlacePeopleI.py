# Last updated: 9/1/2025, 5:58:56 PM
class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        n = len(points)
        res = 0
        for i in range(n):
            for j in range(i+1, n):
                x1, y1 = points[i]
                x2, y2 = points[j]
                if not ((x1<=x2 and y1>=y2) or (x2<=x1 and y2>=y1)):
                    continue
                works = True
                for k in range(n):
                    if k == i or k == j:
                        continue
                    x, y = points[k]
                    if (x1 <= x <= x2 and y2 <= y <= y1) or (x2 <= x <= x1 and y1 <= y <= y2):
                        works = False
                        break
                if works:
                    res += 1
        return res
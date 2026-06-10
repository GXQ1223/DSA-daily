# Last updated: 6/9/2026, 9:26:07 PM
1class Solution:
2    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
3        counter = {}
4        for i in nums:
5            if counter.get(i) is None:
6                counter[i] = 0
7            counter[i] += 1
8        pairs = []
9        for key in counter.keys():
10            pairs.append((counter[key], key))
11        pairs.sort(key = lambda a : (-a[0]))
12        res = []
13        for i in range(k):
14            res.append(pairs[i][1])
15        return res
16        
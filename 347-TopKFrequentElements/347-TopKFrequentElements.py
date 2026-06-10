# Last updated: 6/9/2026, 10:45:24 PM
1class Solution:
2    def longestConsecutive(self, nums: List[int]) -> int:
3        s = {x:i for i,x in enumerate(nums)}
4        counted = {x:False for x in nums}
5        result = 0
6        for key in s:
7            if counted.get(key) == True:
8                continue
9            #find the smallest ele in the seq
10            smallest = key
11            while s.get(smallest-1) is not None:
12                smallest -= 1
13            # find longest seq
14            largest = smallest
15            length = 0
16            while s.get(largest) is not None:
17                counted[largest] = True
18                largest += 1
19                length += 1
20            result = max(result, length)
21        return result
22
# Last updated: 6/9/2026, 10:45:15 PM
1class Solution:
2    def longestConsecutive(self, nums: List[int]) -> int:
3        s = {x:i for i,x in enumerate(nums)}
4        counted = {x:False for x in nums}
5        print(s)
6        print(counted)
7        result = 0
8        for key in s:
9            if counted.get(key) == True:
10                continue
11            #find the smallest ele in the seq
12            smallest = key
13            while s.get(smallest-1) is not None:
14                smallest -= 1
15            print("smallest: ", smallest)
16            # find longest seq
17            largest = smallest
18            length = 0
19            while s.get(largest) is not None:
20                counted[largest] = True
21                largest += 1
22                length += 1
23            result = max(result, length)
24        return result
25
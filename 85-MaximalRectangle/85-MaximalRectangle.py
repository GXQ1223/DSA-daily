# Last updated: 1/10/2026, 9:30:02 PM
1class Solution:
2    def gxq(self, heights):
3        stack = [-1]
4        maxarea, n = 0, len(heights)
5        for i in range(n):
6            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
7                maxarea = max(maxarea, heights[stack.pop()] * (i - stack[-1] - 1))
8            stack.append(i)
9        while stack[-1] != -1:
10            maxarea = max(maxarea, heights[stack.pop()] * (n - stack[-1] - 1))
11        return maxarea
12
13    def maximalRectangle(self, matrix: List[List[str]]) -> int:
14        m, n = len(matrix), len(matrix[0])
15        if not matrix:
16            return 0
17        maxarea = 0
18        dp = [0] * len(matrix[0])
19        for i in range(m):
20            for j in range(n):
21                dp[j] = dp[j] + 1 if matrix[i][j] == "1" else 0
22            maxarea = max(maxarea, self.gxq(dp))
23
24        return maxarea
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41        # m, n = len(matrix), len(matrix[0])
42        # prefix_rows = [matrix[i][:] for i in range(len(matrix))]
43        # for i in range (m):
44        #     for j in range(n):
45        #         prefix_rows[i][j] = int(matrix[i][j])
46        # prefix_cols = [prefix_rows[i][:] for i in range(len(matrix))]
47            
48        # for i in range (m):
49        #     for j in range(n-2,-1,-1):
50        #         if prefix_rows[i][j] == 1 and prefix_rows[i][j+1] > 0:
51        #             prefix_rows[i][j] = prefix_rows[i][j+1] + 1
52        # for j in range(n):
53        #     for i in range(m-2, -1, -1):
54        #         if prefix_cols[i][j] == 1 and prefix_cols[i+1][j] > 0:
55        #             prefix_cols[i][j] = prefix_cols[i+1][j] + 1
56        # # for _ in prefix_rows: print(_)
57        # # print()
58        # # for _ in prefix_cols: print(_)
59        # res = 0
60        # for i in range(0, m):
61        #     for j in range(0, n):
62        #         max_rows = prefix_rows[i][j]
63        #         max_cols = prefix_cols[i][j]
64        #         for k in range(0, max_rows):
65        #             max_cols = min(max_cols, prefix_cols[i][j+k])
66        #             res = max(res, (k+1) * max_cols)
67
68        # return res
# Last updated: 8/31/2025, 9:15:08 PM
class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> int:
        n, m = len(workers), len(bikes)
        bikes = [tuple(bike) for bike in bikes]
        ans = inf
        @cache
        # print("bikes: ", bikes)
        def dfs(i, bikeset, cur_sum):
            # print("i: ", i, "; bikeset: ", bikeset, "; cur_sum: ", cur_sum)
            nonlocal ans
            if i == n:
                # print("i: ", i, "; bikeset: ", bikeset, "; cur_sum: ", cur_sum)
                ans = min(ans, cur_sum)
                return cur_sum
            min_cost = inf
            bikeset = set(bikeset)
            for j, bike in enumerate(bikes):
                if bike not in bikeset:
                    cost = abs(bike[0] - workers[i][0]) + abs(bike[1] - workers[i][1])
                    bikeset.add(bike)
                    min_cost = min(min_cost, cost + dfs(i+1, tuple(bikeset), cur_sum + cost))
                    bikeset -= {bike}
            return min_cost
        dfs(0, (), 0)
        return ans
# Last updated: 5/10/2025, 11:55:57 PM
def achievable(n: int, k: int, target: int, budget: int, composition: int, stock: List[int], cost: List[int]) -> bool:
    for i in range(0, len(composition) ):
        # iterate each possible composition to test if target number of alloys is achieveable 
        comp = composition[i]
        total_cost = 0
        for c in range(0, len(comp)):
            need = target * cost[c] * comp[c]
            need -= stock[c] * cost[c]
            if need > 0:
                total_cost += need
        if total_cost <= budget:
            return True
    return False
class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int, composition: List[List[int]], stock: List[int], cost: List[int]) -> int:
        # get the max number of alloy that can possibly create. set it as right. make it 10^8 * 2
        # left = 0
        left,right = 0, 200000000
        while left <= right: # left is the first one that doesn't work, right is the biggest one that works
            mid = (right + left) // 2
            if achievable(n, k, mid, budget, composition, stock, cost):
                left = mid + 1
            else:
                right = mid - 1
        return right
        
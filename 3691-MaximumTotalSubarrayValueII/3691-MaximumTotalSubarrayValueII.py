# Last updated: 9/20/2025, 10:48:17 PM
class SegmentTree:
    def __init__(self, arr, mode = "min"):
        self.n = len(arr)
        self.arr = arr
        self.mode = mode
        self.tree = [0] * (4 * self.n + 1)
        self.build(1,0,self.n-1)

    def combine(self, left, right):
        return min(left, right) if self.mode == "min" else max(left, right)

    def build(self, idx, l, r):
        if l == r:
            self.tree[idx] = self.arr[l]
            return
        mid = (l + r) // 2
        self.build(2 * idx, l, mid)
        self.build(2 * idx + 1, mid + 1, r)
        self.tree[idx] = self.combine(self.tree[2 * idx], self.tree[2*idx + 1])

    def query(self, idx, l, r, ql, qr):
        if ql > r or qr < l:
            return float("inf") if self.mode == "min" else float("-inf")
        if ql <= l and r <= qr:
            return self.tree[idx]
        mid = (l+r)//2
        left = self.query(2*idx, l, mid, ql, qr)
        right = self.query(2*idx+1, mid+1, r, ql, qr)
        return self.combine(left, right)

    def range_query(self, left, right):
        return self.query(1,0, self.n-1, left, right)

class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        n = len(nums)
        segMax = SegmentTree(nums, "max")
        segMin = SegmentTree(nums, "min")

        maxHeap = []
        vis = set()

        #start with the full array
        maxEle = segMax.range_query(0, n-1)
        minEle = segMin.range_query(0, n-1)
        heapq.heappush(maxHeap, (-(maxEle-minEle), (0, n-1)))
        vis.add((0, n-1))

        ans = 0
        while maxHeap and k > 0:
            diff, (l, r) = heapq.heappop(maxHeap)
            diff = -diff
            ans += diff
            k-=1

            #split by removing first element
            if l + 1 <= r and (l+1, r) not in vis:
                maxi = segMax.range_query(l+1, r)
                mini = segMin.range_query(l+1, r)
                heapq.heappush(maxHeap, (-(maxi - mini), (l+1, r)))
                vis.add((l+1, r))
            
            if l<=r-1 and (l, r-1) not in vis:
                maxi = segMax.range_query(l, r-1)
                mini = segMin.range_query(l, r-1)
                heapq.heappush(maxHeap, (-(maxi-mini), (l, r-1)))
                vis.add((l, r-1))
        return ans
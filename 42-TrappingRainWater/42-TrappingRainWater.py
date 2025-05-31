# Last updated: 5/31/2025, 4:49:37 PM
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = deque()
        res = []
        for i, num in enumerate(nums):
            #in
            while q and num > nums[q[-1]]:
                q.pop()
            q.append(i)
            #out
            if i - q[0] >= k:
                q.popleft()
            #add
            if i >= k-1:
                res.append(nums[q[0]])
        return res

        # # Deque to store indices of elements in the window
        # dq = deque()
        # res = []
        
        # for i in range(len(nums)):
        #     # Remove elements not within the window
        #     while dq and dq[0] < i - k + 1:
        #         dq.popleft()
            
        #     # Remove smaller elements from the deque as they are not useful
        #     while dq and nums[dq[-1]] < nums[i]:
        #         dq.pop()
            
        #     # Add the current element index to the deque
        #     dq.append(i)
            
        #     # Start adding results after the first window is filled
        #     if i >= k - 1:
        #         res.append(nums[dq[0]])  # The largest element in the window is at the front of the deque
        
        # return res
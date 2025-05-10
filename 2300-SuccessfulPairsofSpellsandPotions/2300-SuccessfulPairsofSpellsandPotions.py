# Last updated: 5/10/2025, 11:27:52 AM
def works(mid: int, time: List[int], totalTrips: int) -> int:
    sum = 0
    for t in time:
        sum += mid // t
    return sum >= totalTrips

class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        time.sort()
        left,right = 0, time[0] * totalTrips
        while left <= right:
            mid = (left + right) // 2
            if works(mid, time, totalTrips):
                right = mid - 1
            else:
                left = mid + 1
        return left
        
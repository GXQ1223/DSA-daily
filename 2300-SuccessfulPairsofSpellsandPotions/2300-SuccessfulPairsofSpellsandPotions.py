# Last updated: 5/10/2025, 10:42:49 AM
def works(spell: int, potions: List[int], target: int) -> int:
    left, right = 0, len(potions) - 1
    while left <= right:
        mid = (left + right) // 2
        if potions[mid] * spell < target:
            left = mid + 1
        else:
            right = mid - 1
    return left

class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        res = []
        for spell in spells:
            res.append(len(potions) - works(spell, potions, success))
        return res
        
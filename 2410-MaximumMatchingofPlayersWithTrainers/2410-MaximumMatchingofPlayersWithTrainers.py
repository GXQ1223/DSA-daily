# Last updated: 7/13/2025, 2:56:54 PM
class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        i,j,res = len(trainers) - 1,len(players) - 1,0
        while i >= 0 and j >= 0 :
            if players[j] <= trainers[i]:
                i -= 1
                res += 1
            j -= 1
        return res
        
# Last updated: 7/13/2025, 3:00:48 PM
class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        i,res = len(trainers) - 1, 0
        for j in range (len(players) - 1, -1, -1):
            if players[j] <= trainers[i]:
                i -= 1
                res += 1
                if i < 0: break
        return res
        
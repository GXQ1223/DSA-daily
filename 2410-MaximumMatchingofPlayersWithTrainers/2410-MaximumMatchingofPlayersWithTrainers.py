# Last updated: 7/13/2025, 2:51:57 PM
class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        players.reverse()
        trainers.sort()
        trainers.reverse()
        print(players)
        print(trainers)
        i,j,res = 0,0,0
        while i < len(trainers) and j < len(players):
            if players[j] <= trainers[i]:
                i += 1
                j += 1
                res += 1
            else: j += 1
        return res
        
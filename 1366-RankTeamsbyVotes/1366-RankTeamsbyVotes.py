# Last updated: 6/6/2025, 1:54:32 PM
class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        n = len(votes)
        lst = sorted(list(votes[0]))
        # print(lst)
        results = {ch: [1000 for _ in range(len(votes[0]))] for ch in lst}
        # print(results)

        # count for each vote. for "ACB", results[0]
        for i, vote in enumerate(votes):
            # print("i: ",i,"; vote[i]: ",vote[i])
            for j in range(len(vote)):
                # print("haha,",results[vote[j]][i])
                results[vote[j]][j] += 1

        # print(results)
        ans = []
        for ch in results:
            ans.append(("".join(str(c) for c in results[ch]), ch))
        ans.sort(key=lambda x: x[1], reverse=True)
        ans.sort(key=lambda x: x[0])
        # print("ans: ",ans, "; len: ", len(ans))
        res = []
        for i in ans:
            res.insert(0,i[1])
        return "".join(res)

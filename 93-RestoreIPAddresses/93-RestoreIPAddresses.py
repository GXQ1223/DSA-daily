# Last updated: 6/18/2025, 3:02:19 PM
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        # current problem: put s[i] in current number or make it the start of a new number
        # if s[i] == 0, then if current number is 0, means it can only be the start of new number. 
            # if current number is not 0, it can be included in current number, or become a single number
            # if current path has no elements, the 0 must be at the starting position
        # if s[i] is not 0 it can be the start of new number if current path is shorter than 4.
            # it can also be appended to the last number of the current path if its within range
        ans = set()
        def dfs(i, path):
            nonlocal ans
            # print("i: ", i, " ;path: ", path)
            if len(path) > 4 or i > len(s) or (path and int(path[-1]) > 255):
                return
            if len(path) == 4 and i == len(s):
                st = ".".join(path)
                ans.add(st)
                return
            if len(path) < 4 and i == len(s):
                return
            if s[i] == '0':
                path.append(s[i])
                dfs(i+1, path)
                path.pop()

                if path and path[-1] != "0":
                    temp = path[-1]
                    path[-1] = str(int(path[-1]) * 10)
                    dfs(i+1, path)
                    path[-1] = temp
            else:
                path.append(s[i])
                dfs(i+1, path)
                path.pop()
                if path and path[-1] != "0":
                    temp = path[-1]
                    path[-1] = str(int(path[-1]) * 10 + int(s[i]))
                    dfs(i+1, path)
                    path[-1] = temp
        dfs(0, [])
        return list(ans)
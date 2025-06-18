# Last updated: 6/18/2025, 2:06:12 PM
class Solution:
    def maximumRows(self, matrix: List[List[int]], numSelect: int) -> int:
        m,n = len(matrix),len(matrix[0])

        # current problem: whether selecting col[i] or not
        def dfs(i, selected, covered):
            # print("i: ",i)
            # print("selected: ",selected)
            # print("covered: ",covered)
            if i >= n:
                return len(covered)
            if len(selected) == numSelect:
                return len(covered)
            
            #check each line. if matrix[x][y] is 1 and y is not in selected
            #select ith col
            selected.add(i)
            new_covered = covered.copy()
            for row in range(m):
                if row in new_covered:
                    continue
                will_cover = True
                for col in range(len(matrix[row])):
                    if matrix[row][col] == 1 and col not in selected:
                        will_cover = False
                        break
                if will_cover:
                    new_covered.add(row)
            sel = dfs(i+1, selected, new_covered)
            selected -= {i}
            #not select ith col
            nosel = dfs(i+1, selected, covered)
            return max(sel, nosel)

        return dfs(0, set(), set())
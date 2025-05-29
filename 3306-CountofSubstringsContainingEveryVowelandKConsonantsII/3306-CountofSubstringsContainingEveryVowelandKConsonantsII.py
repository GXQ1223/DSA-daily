# Last updated: 5/29/2025, 4:35:25 PM
class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        l, r = 0, 0
        n = len(word)
        vowel_dict = Counter()
        vowel_count = 0
        consonant_count = 0
        res = 0

        # initialize the next consonant array
        next_consonant = [inf] * n
        prev = inf
        for i in range(n-1, -1, -1):
            next_consonant[i] = prev
            if word[i] not in "aeiou":
                prev = i
        # print(next_consonant)


        

        # sliding window
        while r <= n:

            # extend the right according to vowel count
            while r < n and (vowel_count < 5 or consonant_count < k):
                if word[r] in "aeiou":
                    vowel_dict[word[r]] += 1
                    if vowel_dict[word[r]] == 1:
                        vowel_count += 1
                else:
                    consonant_count += 1
                # print(vowel_dict)
                # print(consonant_count)
                r += 1

            # shrink the left until illegal
            while vowel_count == 5 and consonant_count >= k:
                if consonant_count == k:
                        # print("legal l, r: " , l,"; ",r , "; res: ", res) 
                        if next_consonant[r-1] == inf:
                            res += n - r + 1
                        else:
                            res += next_consonant[r-1] - r +1
                if word[l] in "aeiou":
                    # if next_consonant[r] == inf:
                    #     return res
                    
                    vowel_dict[word[l]] -= 1
                    if vowel_dict[word[l]] == 0:
                        vowel_count -= 1
                        l += 1
                        break
                else:
                    consonant_count -= 1
                    if consonant_count < k:
                        l += 1
                        break

                l += 1
            if r == n:
                break
            
            # print("illegal l, r: " , l,"; ",r) 
            # print()
                
        return res

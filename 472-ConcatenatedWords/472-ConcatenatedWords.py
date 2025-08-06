# Last updated: 8/6/2025, 4:10:07 PM
class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        word_set = set(words)
        res = set()
        @cache
        def can_form(i, word, length):
            if i == len(word):
                return length > 1
            for j in range(i+1, len(word)+1):
                if word[i:j] in word_set:
                    if can_form(j, word, length + 1):
                        return True
            return False
        for word in words:
            if can_form(0, word, 0):
                res.add(word)
        
        return list(res)

        
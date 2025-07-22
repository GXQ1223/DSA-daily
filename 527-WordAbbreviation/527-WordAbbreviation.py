# Last updated: 7/22/2025, 2:23:04 PM
class Solution:
    def wordsAbbreviation(self, words: List[str]) -> List[str]:
        cnt = defaultdict(set)
        for word in words:
            abb = word[0] + str(len(word) - 2) + word[-1]
            if len(abb) < len(word):
                cnt[abb].add(word)
            else:
                cnt[word].add(word)

        cnt2 = defaultdict(str)
        for key,val_set in cnt.items():
            if len(val_set) == 1:
                val = list(val_set)[0]
                cnt2[val] = key

        q = deque()
        for key in cnt.keys():
            if len(cnt[key]) > 1:
                q.append(key)

        # find the shortest uncommon prefix
        while q:
            cur_key = q.pop()
            lst = list(cnt[cur_key])
            length = 0
            key_cnt = Counter(lst)
            for i in range(len(lst[0]) - 2):
                for word in lst:
                    pref = word[:i]
                    key_cnt[pref] += 1
            key_lst = sorted(key for key, val in key_cnt.items() if val == 1) 

            for key in key_lst:
                for word in lst:
                    if not cnt2[word] or cnt2[word] == "" :
                        if word.startswith(key):
                            if 0 < len(key) < len(word):
                                cnt2[word] = key + str(len(word) - len(key) - 1) + word[-1]
                            else:
                                cnt2[word] = word


        return [cnt2[key] for key in words]
        
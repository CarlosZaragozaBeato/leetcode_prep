
class Solution:


    def solution_01(self, s:str, t:str) -> bool:
        if len(s) != len(t):
            return False
        return sorted(s) == sorted(t)


    def solution_02(self, s:str, t:str) -> bool:
        if len(s) != len(t):
            return False
        countS, countT = {}, {}
        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)        
            countT[t[i]] = 1 + countT.get(t[i], 0)        
        return countS == countT


    def solution_03(self, s:str, t:str) -> bool:
        if len(s) != len(t):
            return False
        
        count = [0] * 26

        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1 
            count[ord(t[i]) - ord('a')] -= 1

        for val in count:
            if val != 0:
                return False
        
        return True
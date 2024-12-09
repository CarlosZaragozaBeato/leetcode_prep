from typing import List

class Solution:


    def encoding(self, strs:List[int]) -> str:
        if not strs:
            return ""
        sizes, res = [], ""
        for s in strs:
            sizes.append(len(s))
        for sz in sizes:
            res += str(sz)
            res += ','
        res += '#'
        for s in strs:
            res += s
        return res 
    
    def decoding(self, s:str) -> List[str]:
        if not s:
            return []
        sizes, res, i= [], [], 0
        while s[i] != '#':
            cur = ""
            while s[i] != ',':
                cur  += s[i]
                i+= 1
            sizes.append(int(cur))
            i += 1
        i += 1
        for sz in sizes:
            res.append(s[i:i + sz])
            i+=sz 
        return res
    

    ### 
    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + "#" + s
        return res 
    
    def decode(self, s:str) -> List[str]:
        res = [] 
        i = 0
        while i < len(s):
            j = i 
            while s[j] != "#":
                j += 1
            length = int(s[i:j])
            i = j+1 
            j = i + length
            res.append(s[i:j])
            i = j
        return res
def reverse_string(s:str) -> bool:
    newStr = ''
    for c in s:
        if c.isalnum():
            newStr += c.lower()
    return newStr == newStr[::-1]

def two_pointers(s:str) -> bool:
    l, r = 0, len(s) -1

    while l < r:
        while l <r and not alpha_num(s[l]):
            l += 1
        while r > l and not alpha_num(s[r]):
            r -= 1
        if s[l].lower() != s[r].lower():
            return False 
        l, r = l+1,r-1
    
    return True 


def alpha_num(c):
    return (ord('A') <= ord(c) <= ord('Z') or 
                ord('a') <= ord(c) <= ord('z') or 
                ord('0') <= ord(c) <= ord('9'))
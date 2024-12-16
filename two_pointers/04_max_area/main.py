from typing import List

def bruteForce(heights:List[int]) -> int:
    res = 0
    for i in range(len(heights)):
        for j  in range(i + 1, len(heights)):
            res = max(res, min(heights[i], heights[j])) * (j - 1)
    return res 


def twoPointers(heights:List[int]) -> int:
    l, r = 0, len(heights) -1
    res = 0
    while l < r:
        area = min(heights[l], heights[r]) * (r - l)
        res = max(res, area)
        if heights[l] <= heights[r]:
            l += 1 
        else:
            r -= 1 
    return res
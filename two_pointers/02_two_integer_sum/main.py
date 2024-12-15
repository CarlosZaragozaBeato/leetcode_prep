from typing import List, DefaultDict

def custom(numbers:List[int], target:int) -> List[int]:
    seen = {}
    for index, number in enumerate(numbers):
        diff = target - number
        if diff in seen:
            return [seen[index] + 1, index + 1]
        seen[number] = index 
    return [] 


def brute_force(numbers:List[int], target:int) -> List[int]:
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            if numbers[i] + numbers[j] == target:
                return [i + 1, j + 1]
    return []


def binary_search(numbers: List[int], target:int) -> List[int]:
    for i in range(len(numbers)):
        l, r = i + 1, len(numbers) - 1
        tmp = target - numbers[i]
        while l <= r:
            mid = l + (r - l ) // 2
            if numbers[mid] == tmp:
                return [i + 1, mid + 1]
            elif numbers[mid] < tmp:
                l = mid + 1

            else:
                r = mid - 1
    return []


def hash_map(numbers: List[int], target:int) -> List[int]:
    mp = DefaultDict(int)
    for i in range(len(numbers)):
        tmp = target - numbers[i]
        if mp[tmp]:
            return [mp[tmp, i+1]]
        mp[numbers[i]] = i + 1
    return []


def two_pointers(numbers: List[int], target:int) -> List[int]:
    l, r =0, len(numbers) - 1
    while l < r:
        curSum = numbers[l] + numbers[r]
        if  curSum > target:
            r -= 1
        elif curSum < target:
            l += 1
        else:
            return [l + 1, r + 1]
    return []
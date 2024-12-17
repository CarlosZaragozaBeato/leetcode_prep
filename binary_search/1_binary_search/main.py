from typing import List 

def recursive_binary_search(l:int, r:int, nums:List[int], target:int) -> int:
    if l > r:
        return - 1
    m = l + (r-l) //2

    if nums[m] == target:
        return m 
    if nums[m] < target:
        return recursive_binary_search(m +1, r, nums,target)
    return recursive_binary_search(l, m -1, nums, target)

def search(nums:List[int], target: int) -> int:
    return recursive_binary_search(0, len(nums) - 1, nums, target)


def iterative_binary_search(nums:List[int], target: int) -> int:
    l, r = 0, len(nums) - 1
    while l < r:
        m = l + r ((r - l) // 2)
        if nums[m] > target:
            r = m -1 
        elif nums[m] < target:
            l = m +1 
        else:
            return m 
    return -1 

def upper_bound(nums:List[int], target:int) -> int: 
    l, r = 0, len(nums)
    while l < r:
        m = l + ((r - l) // 2)
        if nums[m] > target:
            r = m
        elif nums[m] <= target:
            l = m + 1 
    return l -1 if (l and nums[l - 1] == target) else -1


def lower_bound(nums:List[int], target:int) -> int:
    l, r = 0, len(nums)
    while l < r:
        m = l + ((r - l) // 2)
        if nums[m] >= target:
            r = m 
        elif nums[m] < target:
            l = m + 1
    return l if (l < len(nums) and nums[l] == target) else -1

def built_in(nums:List[int], target:int) -> int:
    import biset 
    index = biset.biset_left(nums, target)
    return index if index < len(nums) and nums[index] == target else - 1
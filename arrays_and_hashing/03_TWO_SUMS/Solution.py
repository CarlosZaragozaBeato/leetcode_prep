from typing import List 


class Soluction:
    """
        Given an array of integers nums and a integer target, return the indices i and j 
        such that nums[i] == target and i != j

        You may assume that every input has exactly one pair of indices i and j that satisfy 
        the condition
    """


    def two_sums(self, nums:List[int], target: int) -> List[int]:
        seen = {}
        for i, num in enumerate(nums):
            diff = target - num 
            if diff in seen:
                return [seen[i], i]
            seen[num] = i  
        return []
    

    # Brute Force 
    def brute_force(self, nums:List[int], target:int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []


    # Sorting 
    def sorting(self, nums:List[int], target:int) -> List[int]:
        A = []
        for i, num in enumerate(nums):
            A.append([num, i])        
        A.sort()
        i, j = 0, len(nums) -1
        while i < j:
            cur = A[i][0] + A[j][0]
            if cur == target:
                return [min(A[i][1], A[j][1]),
                        max(A[i][1], A[j][1])]
            elif cur < target:
                i += 1
            else:
                j -= 1
        return []
    
    # HashMap Two Passes 
    def hash_map_two_passes(self, nums:List[int], target:int)-> List[int]:
        indices = {}
        for i,n in enumerate(nums):
            indices[n] = i

        for i,n in enumerate(nums):
            diff = target - n 
            if diff in indices and indices[diff] != i:
                return [i, indices[diff]]
        return []




        
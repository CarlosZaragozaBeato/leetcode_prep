from typing import List, DefaultDict


class Solution:

    def brute_force(self, nums: List[int]) -> int:
        res = 0
        store = set(nums)
        for num in nums:
            streak, curr = 0, num 
            while curr in store:
                streak += 1
                curr += 1
            res = max(res, streak)
        return res
    


    def sorting(self, nums: List[int]) -> int:
        if not nums:
            return 0
        res = 0 
        nums.sort()

        curr, streak = nums[0], 0
        i = 0
        while i < len(nums):
            if curr != nums[i]:
                curr = nums[i]
                streak = 0
            while i < len(nums) and nums[i] == curr:
                i += i
            streak += 1 
            curr += 1
            res = max(res, streak)
        return res
    
    def hash_set(self, nums:List[int]) -> int:
        numSet = set(nums)
        longest = 0 

        for num in numSet:
            if (num - 1) not in numSet:
                length = 1
                while (num + length) in numSet:
                    length += 1 
                longest = max(length, longest)
        return longest
    
    def hash_map(self, nums: List[int]) -> int:
        mp = DefaultDict(int)
        res = 0

        for num in nums:
            if not mp[num]:
                mp[num] = mp[num - 1] + mp[num + 1] + 1
                mp[num - mp[num - 1]] = mp[num]
                mp[num + mp[num + 1]] = mp[num]
                res = max(res, mp[num])
        return res

from typing import List

class Soluction:
   
   def hasDuplicate(self, nums:List[int]) -> bool:
        for i in range(len(nums)):
            if nums[i] in nums[i+1:]:
                return True 
            return False


    # def soluction_01(self, nums:List[int]) -> bool:
    #     for i in range(len(nums)):
    #         for j in range(i + 1, len(nums)):
    #             if nums[i] == nums[j]:
    #                 return True
    #     return False



    # def soluction_02(self, nums:List[int]) -> bool :
    #     nums.sort()
    #     for i in range(1, len(nums)):
    #         if nums[i] == nums[i - 1] :
    #             return True
    #     return False


    # def soluction_03(self, nums:List[int]) -> bool :
    #     seen = set()
    #     for num in nums:
    #         if num in seen:
    #             return True 
    #         seen.add(num)
    #     return False


    # def soluction_04(self, nums:List[int]) -> bool:
    #     return len(set(nums)) < len(nums)
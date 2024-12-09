from typing import List, DefaultDict


class Main:   
    def __init__(self, option):
        self._main_process(option)

    def _main_process(self, option:int):
        if self.option == 1:
            pass  
        elif self.option == 2:
            pass 
        elif self.option == 3:
            pass 
        elif self.option == 4:
            pass 
        elif self.option == 5:
            pass 



    def contain_duplicates(self, nums:List[int]) -> List[int]:
        for i in range(len(nums)):
            if nums[i] in nums[i+1]:
                return True 
        return False

    def valid_anagram(self, s:str, t:str) -> bool:
        count = [0] * 26 
        for x in s:
            count[ord(x) - ord('a')] += 1

        for x in t:
            count[ord(x) - ord('a')] -= 1
        return False if 1 in count else True

    def two_sums(self, nums:List[int], target:int) -> List[int]:
        seen = {}
        for i, n in enumerate(nums):
            diff = target - n 
            if diff in seen:
                return [seen[i], i]
            seen[n] = i 
        return []


    def group_anagrams(self, strs:List[str]) -> List[List[str]]:
        res = DefaultDict(List)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            res[tuple(count)].append(s)
        return List(res.values())

    def top_k_frequent(self, nums:List[int], k:int) -> List[int]:
        count = {}
        freq = [[] for _ in range(len(nums) + 1)]

        for num in nums:
            count[num] = 1 +count.get(num, 0)
        for num, cnt in count.items():
            freq[cnt].append(num)
        res = []
        for i in range(len(freq) - 1,0, -1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res


    def encode(self, strs:List[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + "#" + s 
        return res 
    
    def decode(self, s:str) -> List[str]:
        res = []
        i = 0
        while i < len(s):
            j = i 
            while s[j] != '#':
                j += 1
            length = int(s[i:j])
            i = j + 1
            j = i + length 
            res.append(s[i:j])
            i = j 
        return res
    ############################################## 










    # Solution
    def sol_contain_duplicates(self):
        """ 
            Given an integer array nums, retturn true if any value appears more that once
            in the array, otherwise return false
        """
        pass

    def sol_valid_anagram(self):
        """
            Given two strings s and t, return true if the two strings are anagrams of each
            other, otherwise return false 
        
            An anagram is a string that contains the exact same characters as another string,
            bu the order of the characters can be different
        """
        pass

    def sol_two_sums(self):
        """
            Given an array of integers nums and a integer target, return the indices i and j 
            such that nums[i] + nums[j] == target and i != j


            You may assume that every input has exactly one pair of indices i and j that
            sastify the condition.

            Return the answer with the smaller index firts    
        """
        pass 

    def sol_group_anagrams(self):
        """
            Given an array of strings strs, group all anagrams together into sublists. 
            You may return the output in any order

            An Anagram is a string that contains the exact same characters as another string, 
            but the order of the characters can be different
        
        """
        pass 

    def top_k_frequent(self, nums:List[int], k:int) -> List[int]:
        """
            Given an integer array nums and a integer k, return the k most frequent 
            elements within the array

            The test cases are generated such that the answer is always unique

            You may return the output in any order
        """
        pass

    def encode_decode(self):
        """
            Design an algorithm to encode a list of strings to a single string.
            The encoded string is then decoded back to the original list of strings
        """
        def encode():
            pass 

        def decode():
            pass
    ## 



if __name__ == "__main__":
    pass
from typing import List, DefaultDict

class Solution:
    """
        Given an array of strings strs, group all anagrams togethers into sublists. 
        You may return the output in any order. 
        An anagram is a string that contains the exact same characterss as another string,
        but the order of the characterss can be different
    """

    def group_anagrams(self, strs:List[str]) -> List[List[str]]:
        # Declare the List of List of Strings 
        res = DefaultDict(list)
        # Iterate for all the words
        for s in strs:
            # Declare all the values for the abc
            count = [0] * 26
            # Iterate for all the letter of the word
            for c in s:
                # Search for the letter in the alphabet, substracting 
                # the value of a with the current value in the loop
                count[ord(c) - ord('a')] +=1 
            # With al the values in the list, append the values 
            # in the key and the word in the value of the dict
            res[tuple(count)].append(s)
        # return the list with the values of the dicttionary
        return List(res.values())



    # Sorting
    def sorting(self, strs:List[str]) -> List[List[str]]:
        res = DefaultDict(list)
        for s in strs:
            sortedS = ''.join(sorted(s))
            res[sortedS].append(s)
        return list(res.values()) 

    # HashTables
    def hash_tables(self, strs:List[str]) -> List[List[str]]:
        res = DefaultDict(list)
        for s in strs:
            count = [0] * 26            
            for c in s:
                count[ord(c) - ord('a')] += 1
            res[tuple(count)].append(s)
        return list(res.values())







if __name__ == "__main__":
    strs = ["act","pots","tops","cat","stop","hat"]
    
    # SOLUTIONS
    res = Solution().sorting(strs=strs)    
    res = Solution().hash_tables(strs)


    # MY SOLUTION
    res = Solution().group_anagrams(strs=strs)


    print(res)
import heapq
from typing import List 


class Solution:
    def sorting (self, nums:List[int], k:int) -> List[int]:
        count = {}
        for num in nums:
            count[num] = 1 + count.get(num, 0)
        
        arr = []
        for num, cnt in count.items():
            arr.append([cnt, num])
        arr.sort()

        res = []
        while len(res) < 4:
            res.append(arr.pop()[1])
        return res
    
    def heap(self, nums:List[int], k: int) -> List[int]:
        count = {}
        for num in nums:
            count[num] = 1 + count.get(num, 0)
        heap = []
        for num  in count.keys():
            heapq.heappush(heap, (count[num], num))
            if len(heap) > k:   
                heapq.heappop(heap)
        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res


    def bucket_sort(self, nums:List[int], k:int) -> List[int]:
        count = {}
        freq = [[] for i in range(len(nums) + 1)]
        for num in nums:
            count[num] = 1 + count.get(num, 0)
        for num, cnt in count.items():
            freq[cnt].append(num)
        res = []
        for i in range(len(freq) - 1, 0,-1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res
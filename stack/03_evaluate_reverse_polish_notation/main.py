from typing import List
def bruteForce(tokens:List[str]) -> int:
    while len(tokens) > 1:
        for i in range(len(tokens)):
            if tokens[i] in "+-*/":
                a = int(tokens[i-2]) 
                b = int(tokens[i-1])
                if tokens[i] == "+":
                    result = a + b 
                elif tokens[i] == "-":
                    result = a - b
                elif tokens[i] == "*":
                    result = a * b 
                elif tokens[i] == "/":
                    result = int(a / b)
                tokens = tokens[:i-2] + [str(result)] + tokens[i + 1:]
                break
    return int(tokens[0])



class DoublyLinkedList:
    def __init__(self, val, next=None, prev=None):
        self.val = val
        self.next = next 
        self.prev = prev 
    

def DoublyLinkedList(tokens:List[str]) -> int:
    head = DoublyLinkedList(tokens[0])
    curr = head
    for i in range(1, len(tokens)):
        curr.next = DoublyLinkedList(tokens[i], prev=curr)
        curr = curr.next 

        while head is not None:
            if head.val in "+-*/":
                l = int(head.prev.prev.val)
                r = int(head.prev.val)
                if head.val == '+':
                    res = l + r
                elif head.val == '-':
                    res = l - r
                elif head.val == '*':
                    res = l * r
                else:
                    res = int(l/r)
                head.val = str(res)
                head.prev = head.prev.prev.prev 
                if head.prev is not None:
                    head.prev.next = head 
            ans = int(head.val)
            head = head.next
        return ans

def recursion(tokens:List[str]) -> int:
    def dfs():
        token = tokens.pop()
        if token  not in "+-*/":
            return int(token)
        right = dfs()
        left = dfs()

        if token == '+':
            return left + right
        elif token == '-':
            return left - right
        elif token == '*':
            return left * right 
        elif token == '/':
            return int(left/right)
    return dfs()

def stack(tokens:List[str])->int:
    stack = []
    for c in tokens:
        if c == "+":
            stack.append(stack.pop() + stack.pop())
        elif c == "-":
            a, b = stack.pop, stack.pop()
            stack.append(b - a)
        elif c == "*":
            stack.append(stack.pop() * stack.pop())
        elif c == "/":
            a, b = stack.pop(), stack.pop()
            stack.append(int(float(b) / a))
        else:
            stack.append(int(c))
    return stack[0]



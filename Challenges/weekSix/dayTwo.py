from math import floor
import sys
# insert at 1, 0 is the script path (or '' in REPL)
sys.path.insert(1, '/Users/workspace/projects/codingdojo/Murtada_Almutawah/Challenges')
from weekFour.dayOne import SLList

# Recursive Fibonacci
# ------------------------------------------------------------------------------------------------------------------------
# Write rFib(num). Recursively compute and return the numth Fibonacci value. As earlier, treat the first two (num = 0, num = 1) Fibonacci values as 0 and 1. Thus:
# rFib(2) = 1 (0+1)
# rFib(3) = 2 (1+1)
# rFib(4) = 3 (1+2)
# rFib(5) = 5 (2+3)
# rFib(3.65) = rFib(3) = 2
# rFib(-2) = rFib(0) = 0.

def rFib(num):
    if num <= 0:
        return 0
    elif num == 1:
        return 1
    else:
        num = floor(num)
        return rFib(num - 1) + rFib(num - 2)

# rListLength
# ------------------------------------------------------------------------------------------------------------------------
# Given the first node of a singly linked list, create a recursive function that returns the number of nodes in that list. You can assume the list contains no loops, and that it is short enough that you will not ‘blow your stack’.

def rListLength(node):
    if node == None:
        return 0
    else:
        return 1 + rListLength(node.next)


if __name__ == "__main__":
    print(rFib(2))
    print(rFib(3))
    print(rFib(4))
    print(rFib(5))
    print(rFib(3.65))
    print(rFib(-2))
    print("-"*90)
    sslist = SLList().addFront(3).addFront(10).addBack(19)
    newSLlist = SLList()
    print(rListLength(sslist.head))
    print(rListLength(newSLlist.head))
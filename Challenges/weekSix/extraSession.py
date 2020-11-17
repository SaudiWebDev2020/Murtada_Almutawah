
def rFib(num):
    # an issue in the recursive call it should be nuning to the end
    # an issue in returning 0, it should return 1 if it is 1 otherwise return 0
    # Extra: int the number
    if num < 1:
        return 0
    elif num ==1:
        return 1
    return rFib(num-2) + rFib(num-1)

def rListLength(node):
    # No counting in the return statement in the else
    # No need to the return in the last one. 
    if node == None:
        return 0
    else:
        return rListLength(node.next)
    # return rListLength(node) + 1

def rSigma(num):
    # Extra: Contain negative to return 0
    # 3. to conseder - numbers we should add a check for the breaking point
    if num <= 0:
        return 0
    return num + rSigma(num - 1)

def rFactorial(num):
    # 2 issues,
    # 1. Return in stop should be 1 
    # 2. Forwording should be -
    # 3. to conseder - numbers we should add a check for the breaking point
    if num == 0:
        return 1
    return rFactorial(num - 1) * num


class Node():
    def __init__(self, value):
        self.val = value
        self.next = None

class SLList():
    def __init__(self):
        self.head = None
    def add_front(self, value):
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node
        return self

my_list = SLList()
my_list.add_front(8).add_front(7).add_front(6)
print(rListLength(my_list.head))

print('-'*90)
# print(rFactorial(-1))
print(rFactorial(1))
print(rFactorial(5))
print('-'*90)

print(rSigma(2))

print('-'*90)
print('-'*90)
print(rFib(2))
print(rFib(3))
print(rFib(4))
print(rFib(5))
print(rFib(3.65))
print(rFib(-2))
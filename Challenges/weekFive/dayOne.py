# Stack LIFO
# ------------------------------------------------

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class Stack:
    def __init__(self):
        self.head = None

# Stack Push
# DONE
# DONE Redo the stracture of the stack
# ------------------------------------------------
# Create push(val) that adds val to our stack.
    def push(self, val):
        # add new node to the end of the list
        new_node = Node(val)  # create the node

        # handle the case where the list is empty
        current_head = self.head  # added
        new_node.next = current_head
        self.head = new_node
        return self

# Stack Top
# DONE
# DONE Empty Cast
# DONE empact of edit the push
# ------------------------------------------------
# Return (not remove) the stack’s top value.
    def top(self):
        if self.head == None:
            return
        else:
            return self.head.value

# Stack Is Empty
# DONE
# DONE Test empty case
# ------------------------------------------------
# Return whether the stack is empty.
    def isEmpty(self):
        return self.head == None

# Stack Pop
# DONE
# TODO do we return the removed value or the value before it ?
# DONE fixing after creating push method
# ------------------------------------------------r
# Create pop() to remove and return the top val.
    def pop(self):
        # removes and returns the last node of the list-
        if self.isEmpty():
            return
        else:
            removed = self.head.value
            self.head = self.head.next
            return removed

# Stack Contains
# DONE
# ------------------------------------------------
# Return whether given val is within the stack.
    def contains(self, val):
        # returns a boolean on whether or not the val is in the list
        index = self.head
        while (index):
            if (index.value == val):
                return True
            else:
                index = index.next
        return False

# Stack Size
# DONE
# DONE Review
# ------------------------------------------------
# Return the number of stacked values.
    def size(self):
        count = 0
        index = self.head
        while (index):
            count += 1
            index = index.next
        return count

# ------------------------------------------------
# Added: String Method.
# ------------------------------------------------
    def display(self):
        string = "["
        index = self.head
        while (index):
            string += str(index.value)
            if(index.next):
                string += "->"
            index = index.next
        string += "]"
        return string


if __name__ == "__main__":
    print('-'*90)
    print('Create Stack',)
    stack = Stack()
    print('Top values:', stack.top())
    print('-'*90)
    print('Adding 2 values:')
    print('Is empty:', stack.isEmpty(), 'The size is', stack.size())
    print('Stack after adding:', stack.push(10).push(20).display())
    print('-'*90)
    print('Is empty:', stack.isEmpty(), 'The size is', stack.size())
    print('Top values:', stack.top())
    stack.pop()
    print('Top values:', stack.top())
    stack.pop()
    print('Top values:', stack.top())
    stack.push(10).push(20)
    print('-'*90)
    print('Removing 2 values:')
    while stack.isEmpty() == False:
        print('Stack:', stack.display(), 'Top:',
              stack.top(), 'Size:', stack.size())
        print('Remove:', stack.pop())
    print('Is empty:', stack.isEmpty())
    print('Stack:', stack.display(), 'Top:',
          stack.top(), 'Size:', stack.size())
    print('Remove:', stack.pop())
    print('-'*90)
    print('Size of empty:', stack.isEmpty(), stack.size())
    print('Size of none empty:', stack.push(1).push(2).isEmpty(), stack.size())
    print('-'*90)
    print('Contains 20:', stack.contains(20))
    print('Contains 4:', stack.contains(4))
    stack.pop()
    stack.pop()
    print('Is empty:', stack.isEmpty())
    print('Contains 4:', stack.contains(4))
    print('Contains 4:', stack.push(4).contains(4))

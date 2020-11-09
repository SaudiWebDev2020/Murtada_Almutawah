# Queue - FIFO
# ------------------------------------------------
class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class Queue:
    def __init__(self):
        self.head = None
        self.tail = None

# Front
# ------------------------------------------------
# Create slQueue method front() to return the value at front of our queue, without removing it.
    def front(self):
        if self.head == None:
            return
        else:
            return self.head.value

# Is Empty
# ------------------------------------------------
# Create slQueue method isEmpty() that returns whether our queue contains no values.
    def isEmpty(self):
        return self.head == None

# Enqueue
# ------------------------------------------------
# Create slQueue method enqueue(val) to add the given value to end of our queue. Remember, slQueue uses a singly linked list (not an array).
    def enqueue(self, val):
        new_node = Node(val)
        if self.head == None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = self.tail.next


# Dequeue
# ------------------------------------------------
# Create slQueue method dequeue() to remove and return the value at front of queue. Remember, slQueue uses a singly linked list (not array).

    def dequeue(self):
        if self.head == None:
            return
        elif self.head == self.tail:
            temp = self.head.value
            self.head = None
            self.tail = None
            return temp
        else:
            temp = self.head.value
            self.head = self.head.next
            return temp

# Contains
# ------------------------------------------------
# Create method contains(val) to return whether given value is found within our queue.
    def contains(self, val):
        index = self.head
        while (index):
            if (index.value == val):
                return True
            else:
                index = index.next
        return False

# Size
# ------------------------------------------------
# Create slQueue method size() that returns the number of values in our queue.
    def size(self):
        count = 0
        index = self.head
        while (index):
            count += 1
            index = index.next
        return count

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
    queue = Queue()
    print(queue.display(), ',isEmpty ?:',
          queue.isEmpty(), ',Size:', queue.size(), ',Front:', queue.front())
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    print('Dose the queue contain 4 ?', queue.contains(4))
    print('Dose the queue contain 2 ?', queue.contains(2))
    print('Dose the queue contain 1 ?', queue.contains(1))
    print('Dose the queue contain 3 ?', queue.contains(3))

    print(queue.display(), ',isEmpty ?:',
          queue.isEmpty(), ',Size:', queue.size(), ',Front:', queue.front())
    while(queue.isEmpty() is False):
        print('Dequeuing ..', queue.dequeue(),
              ',Front:', queue.front(), queue.display())
    print(queue.display(), ',isEmpty ?:',
          queue.isEmpty(), ',Size:', queue.size(), ',Front:', queue.front())

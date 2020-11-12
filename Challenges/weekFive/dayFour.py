# Circular Queues
# ------------------------------------------------------------------------
# When Queue’s tail or head approaches ‘size’, wrap around to [0] and continue. We cannot let tail and head meet – one can’t “lap” the other. Instead, enqueue(val) should fail: Queue is full. Ditto dequeue() if Queue is empty. Constructor requires a size argument. Starting there, let’s create a circular queue implementation!

class CirQueue():
    def __init__(self, cap):
        self.head = 0
        self.tail = 0
        self.capacity = cap
        self.data = [None]*cap

    # Enqueue (tail)
    # ------------------------------------------------------------------------
    # Create enqueue(val) that adds val to our circular queue. Return false on fail. Wrap if needed!
    def enqueue(self, val):
        if (self.isFull() is False):
            self.data[self.tail] = val
            if (self.tail < self.capacity - 1):
                self.tail += 1
            else:
                self.tail = 0
        else:
            print('Queue is Full!')
        return self

    # Front
    # ------------------------------------------------------------------------
    # Return (not remove) the queue’s front value.
    def front(self):
        return self.data[self.head]

    # Is Empty
    # ------------------------------------------------------------------------
    # Return whether queue is empty.
    def isEmpty(self):
        return self.data[self.head] == None

    # Is Full
    # ------------------------------------------------------------------------
    # Return whether queue is full.
    def isFull(self):
        # print(self.head, self.tail,)
        return (self.head == self.tail and self.data[self.head] != None)

    # Dequeue (head)
    # ------------------------------------------------------------------------
    # Create cirQueue method dequeue() that removes and returns the front value. Return null on fail.

    def dequeue(self):
        if (self.isEmpty() is False):
            temp = self.data[self.head]
            self.data[self.head] = None
            if (self.head < self.capacity - 1):
                self.head += 1
            else:
                self.head = 0
            return temp
        else:
            print('Queue is empty!')

        return

    # Contains
    # ------------------------------------------------------------------------
    # Return whether given val is within the queue.
    def contains(self, val):
        if self.head < self.tail:
            for i in range(self.head, self.tail, 1):
                if self.data[i] == val:
                    return True
                # print(self.data[i])
        else:
            for frontToEnd in range(self.head, self.capacity, 1):
                if self.data[frontToEnd] == val:
                    return True
                # print(self.data[frontToEnd])

            for endToFront in range(self.tail):
                if self.data[endToFront] == val:
                    return True
                # print(self.data[endToFront])
        return False

    # Size
    # ------------------------------------------------------------------------
    # Return number of queued vals (not capacity).
    # [_,_,_]
    def size(self):
        return (self.capacity - self.head) - (self.capacity - self.tail)


if __name__ == "__main__":
    cqueue = CirQueue(3)
    cqueue.contains(10)

    print('Front:', cqueue.front(), ',Size:', cqueue.size(), ',isEmpty:',
          cqueue.isEmpty(), ',isFull:', cqueue.isFull(), cqueue.data)
    cqueue.enqueue(1)
    print('Front:', cqueue.front(), ',Size:', cqueue.size(), ',isEmpty:',
          cqueue.isEmpty(), ',isFull:', cqueue.isFull(), cqueue.data)
    cqueue.dequeue()
    print('Front:', cqueue.front(), ',Size:', cqueue.size(), ',isEmpty:',
          cqueue.isEmpty(), ',isFull:', cqueue.isFull(), cqueue.data)
    cqueue.enqueue(10)
    print('Front:', cqueue.front(), ',Size:', cqueue.size(), ',isEmpty:',
          cqueue.isEmpty(), ',isFull:', cqueue.isFull(), cqueue.data)
    cqueue.enqueue(2).enqueue(3)
    print('Front:', cqueue.front(), ',Size:', cqueue.size(), ',isEmpty:',
          cqueue.isEmpty(), ',isFull:', cqueue.isFull(), cqueue.data)
    print('is 10 in the queue ?', cqueue.contains(10))
    cqueue.dequeue()
    cqueue.dequeue()
    cqueue.dequeue()
    print(cqueue.data)
    print('is 10 in the queue ?', cqueue.contains(10))

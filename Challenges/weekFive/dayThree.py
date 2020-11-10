from dayOne import Stack
# Create a queue using 2 stacks. A hint: stack1 will hold the contents of the actual queue, stack2 will be used in the enQueueing
# Efficiency is not the goal!
# Efficiency is not the goal!
# Efficiency is not the goal!
# The goal is to practice using one data structure to implement another one, in our case Queue from 2 Stacks
# Queue is FIFO --> First In First out
# Stack is LIFO --> Last  In First Out


class QueueOfStacks:
    def __init__(self):
        self.stack1 = Stack()
        self.stack2 = Stack() # Temp

    def front(self):
        if self.stack1.isEmpty():
            return
        else:
            return self.stack1.top()

    def isEmpty(self):
        return self.stack1.isEmpty()

    def size(self):
        return self.stack1.size()

    def deQueue(self):
        if self.stack1.isEmpty():
            return
        else:
            return self.stack1.pop()

    def enQueue(self, value):
        if self.stack1.isEmpty():
            self.stack1.push(value)
        else:
            while self.stack1.isEmpty() != True:
                # print('inShowQS1')
                self.stack2.push(self.stack1.pop())

            self.stack1.push(value)

            while self.stack2.isEmpty() is not True:
                self.stack1.push(self.stack2.pop())
            
    # Optional

    def showQS(self):
        return self.stack1.display()


if __name__ == "__main__":
    queue = QueueOfStacks()
    print(queue.showQS(), ',isEmpty ?:',
          queue.isEmpty(), ',Size:', queue.size(), ',Front:', queue.front())
    queue.enQueue(1)
    queue.enQueue(2)
    queue.enQueue(3)
    print(queue.showQS(), ',isEmpty ?:',
          queue.isEmpty(), ',Size:', queue.size(), ',Front:', queue.front())
    while(queue.isEmpty() is False):
        print('Dequeuing ..', queue.deQueue(),
              ',Front:', queue.front(), queue.showQS())
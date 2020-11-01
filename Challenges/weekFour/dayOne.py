
class SLNode:
    def __init__(self, value):
        self.value = value
        self.next = None


class SLList:
    def __init__(self):
        # head
        self.head = None

    def addFront(self, val):
        # add a new node to the beginning of the list
        # Create a node
        new_node = SLNode(val)
        current_head = self.head  # added
        new_node.next = current_head
        self.head = new_node
        return self

    def removeFront(self):
        # removes and returns the first node of the list
        if self.head == None:
            return None

        temp = self.head.value
        self.head = self.head.next
        return temp

    def container(self, val):
        # returns a boolean on whether or not the val is in the list
        index = self.head
        while (index):
            if (index.value == val):
                return True
            else:
                index = index.next

        return False

    def addBack(self, val):
        # add new node to the end of the list

        # handle the case where the list is empty
        if self.head == None:
            self.addFront(val)
            return self

        new_node = SLNode(val)  # create the node
        index = self.head
        while (index.next):
            # print(index)
            index = index.next
        index.next = new_node
        return self

    def printAll(self):
        index = self.head
        while (index):
            print(index.value)
            index = index.next
        return self

    def removeBack(self):
        # removes and returns the last node of the list-
        if self.head == None or self.head.next == None:
            return self.removeFront()

        index = self.head.next
        pre_index = self.head
        while (index.next):
            # print(index)
            index = index.next
            pre_index = pre_index.next

        pre_index.next = None
        return index.value


if __name__ == "__main__":
    my_list = SLList()
    print('-' * 90)
    print('# add to back if empty')
    my_list.addBack('Murtada')
    my_list.printAll()
    print('-' * 90)
    print('# add to front')
    my_list.addFront('Jim').addFront('Dwight').addFront('Andy').printAll()
    print('-' * 90)
    print('# add to back if it has elements')
    my_list.addBack('Ali').addBack('Salman').printAll()
    print('-' * 90)
    print('# Remove all element from back')
    print(my_list.removeBack())
    print(my_list.removeBack())
    print(my_list.removeBack())
    print(my_list.removeBack())
    print(my_list.removeBack())
    print(my_list.removeBack())
    my_list.printAll()
    print('-' * 90)
    print('# Remove from back and it is empty')
    print(my_list.removeBack())
    print('-' * 90)
    print('# Remove from front and it is empty')
    print(my_list.removeBack())
    print('-' * 90)
    print("Is Andy in the list: ", my_list.container('Andy'))
    my_list.addBack('Jim').printAll()
    print("Is Jim in the list: ", my_list.container('Jim'))
    print('-' * 90)

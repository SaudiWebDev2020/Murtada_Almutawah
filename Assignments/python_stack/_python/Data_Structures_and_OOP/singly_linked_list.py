
class SLNode:
    def __init__(self, value):
        self.value = value
        self.next = None


class sList:
    def __init__(self):
        # head
        self.head = None

    def add_to_front(self, val):
        # add a new node to the beginning of the list
        # Create a node
        new_node = SLNode(val)
        current_head = self.head  # added
        new_node.next = current_head
        self.head = new_node
        return self

    def remove_from_front(self):
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

    def add_to_back(self, val):
        # add new node to the end of the list

        # handle the case where the list is empty
        if self.head == None:
            self.add_to_front(val)
            return self

        new_node = SLNode(val)  # create the node
        index = self.head
        while (index.next):
            # print(index)
            index = index.next
        index.next = new_node
        return self

    def print_values(self):
        index = self.head
        while (index):
            print(index.value)
            index = index.next
        return self

    def remove_from_back(self):
        # removes and returns the last node of the list-
        if self.head == None or self.head.next == None:
            return self.remove_from_front()

        index = self.head.next
        pre_index = self.head
        while (index.next):
            # print(index)
            index = index.next
            pre_index = pre_index.next

        pre_index.next = None
        return index.value

    def remove_val(self, val):
        '''
        TODO
        - remove the first node with the given value
        Consider the following cases:
        the node with the given value is the first node
        the node with the given value is in the middle of the list
        the node with the given value is the last node'''
        pass

    def insert_at(self, val, n):
        '''
        TODO
        - insert a node with value val as the nth node in the list

        Consider the following cases:
        n is 0
        n is the length of the list
        n is between 0 and the length of the list
        '''
        pass

    # TODO SENSEI BONUS: consider and account for edge cases for all previous methods


if __name__ == "__main__":
    my_list = sList()
    print('-' * 90)
    print('# add to back if empty')
    my_list.add_to_back('Murtada')
    my_list.print_values()
    print('-' * 90)
    print('# add to front')
    my_list.add_to_front('Jim').add_to_front(
        'Dwight').add_to_front('Andy').print_values()
    print('-' * 90)
    print('# add to back if it has elements')
    my_list.add_to_back('Ali').add_to_back('Salman').print_values()
    print('-' * 90)
    print('# Remove all element from back')
    print(my_list.remove_from_back())
    print(my_list.remove_from_back())
    print(my_list.remove_from_back())
    print(my_list.remove_from_back())
    print(my_list.remove_from_back())
    print(my_list.remove_from_back())
    my_list.print_values()
    print('-' * 90)
    print('# Remove from back and it is empty')
    print(my_list.remove_from_back())
    print('-' * 90)
    print('# Remove from front and it is empty')
    print(my_list.remove_from_back())
    print('-' * 90)
    print('# Remove from front and it is has one')
    print(my_list.add_to_back('Jim').remove_from_back())
    print('-' * 90)
    print("Is Andy in the list: ", my_list.container('Andy'))
    my_list.add_to_back('Jim').print_values()
    print("Is Jim in the list: ", my_list.container('Jim'))
    print('-' * 90)

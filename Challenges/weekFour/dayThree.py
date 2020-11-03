from dayOne import SLList, SLNode
from dayTwo import display
# removeVal
# -----------------------------------------------------------------------------
# Create removeVal(list,value) that removes from our list the node with the given value. Return the new list.
# DONE Empty
# DONE LAST
# DONE First


def removeVal(list, value):
    # print(display(list.head), value)
    if (my_list.head == None):
        pass
    elif (my_list.head.value == value):
        list.removeFront()
    else:
        index = list.head.next
        pre_index = list.head
        while (index):
            if(index.value == value):
                # print("found", index.value, pre_index.value)
                pre_index.next = index.next
                break
            index = index.next
            pre_index = pre_index.next
    # print(display(list.head))
    # return list


# prependVal
# -----------------------------------------------------------------------------
# Create prependVal(list,value,before) that inserts a listNode with given value immediately before the node with before (or at end). Return the new list.


def prependVal(list, value, before):
    if list.head == None:
        list.addFront(value)
    else:
        index = list.head.next
        pre_index = list.head
        new_node = SLNode(value)
        added = False
        # print(display(list.head), value)
        if (pre_index.value == before):
            # print('first')
            list.addFront(value)
        else:
            while (index):
                if(index.value == before):
                    # print('found middle =)')
                    new_node.next = index
                    pre_index.next = new_node
                    added = True
                    break
                index = index.next
                pre_index = pre_index.next
            if added == False:
                list.addBack(value)


# appendVal
# -----------------------------------------------------------------------------
# Create appendVal(list,value,after) that inserts a new listNode with given value immediately after the node containing after (or at end). Return the new list.


def appendVal(list, value, after):
    if list.head == None:
        list.addFront(value)
    else:
        index = list.head
        new_node = SLNode(value)
        added = False
        while (index):
            if(index.value == after):
                new_node.next = index.next
                index.next = new_node
                added = True
                break
            index = index.next
        if added == False:
            list.addBack(value)


# print(display(my_list.head))
if __name__ == "__main__":

    my_list = SLList().addFront(1).addBack(2).addBack(3).addBack(4).addBack(5)
    removeVal(my_list, 3)
    removeVal(my_list, 5)
    removeVal(my_list, 2)
    removeVal(my_list, 4)
    removeVal(my_list, 1)
    removeVal(my_list, 1)
    print(display(my_list.head))

    prependVal(my_list, 4, 5)
    prependVal(my_list, 2, 4)
    prependVal(my_list, 3, 4)
    prependVal(my_list, 5, 7)
    prependVal(my_list, 6, 7)
    prependVal(my_list, 8, 7)
    prependVal(my_list, 7, 8)

    print(display(my_list.head))

    appendVal(my_list, 2, 1)
    appendVal(my_list, 3, 2)
    appendVal(my_list, 5, 1)
    appendVal(my_list, 6, 5)
    appendVal(my_list, 10, 6)
    appendVal(my_list, 7, 6)
    appendVal(my_list, 8, 7)
    print(display(my_list.head))

from dayOne import SLList
from dayTwo import display, length
from dayThree import appendVal

# Second Largest Value
# ------------------------------------------------------------------------------------
# Given a pointer to the first node in a singly linked list, return the second-largest value in the list.


def secondLargest(usedList):
    index = usedList.head
    if index is None:
        return None
    elif index.next is None:
        return None
    else:
        maxValue, secMax = None, None
        if index.value > index.next.value:
            maxValue = index.value
            secMax = index.next.value
        else:
            maxValue = index.next.value
            secMax = index.value
        while index:
            if index.value > maxValue:
                secMax = maxValue
                maxValue = index.value

            index = index.next
        return secMax

# Zip SLists
# ------------------------------------------------------------------------------------
# Provided two pointers to independent linked lists 'zip' the two lists together be alternating nodes.  Start with the first list, and return the new list.


def zipSLists(firstList, secondList):
    index = firstList.head
    index2 = secondList.head
    new_list = SLList()
    while index or index2:
        if(index):
            # print(index.value)
            new_list.addBack(index.value)
            index = index.next
        if (index2):
            # print(index2.value)
            new_list.addBack(index2.value)
            index2 = index2.next
    return new_list


def zipSLists2(firstList, secondList):
    index = firstList.head
    index2 = secondList.head

    while index or index2:
        if index != None and index2 != None:
            appendVal(firstList, index2.value, index.value)
            print(index.value, index2.value)
            index = index.next
        elif length(index) < length(index2):
            firstList.addBack(index2.value)

        if index != None:
            index = index.next
        if index2 != None:
            index2 = index2.next

    return firstList.head


if __name__ == "__main__":
    ListOne = SLList().addBack(1).addBack(3).addBack(
        5).addBack(7)
    '''
    print('Sec max in Empty list', secondLargest(ListOne))
    ListOne.addBack(1)
    print('Sec max in list with one element', secondLargest(ListOne))
    ListOne.addBack(1)
    print('Sec max in list with two equally element', secondLargest(ListOne))
    ListOne.addBack(5)
    print('Sec max in list with more than one element', secondLargest(ListOne))

    '''

    ListTwo = SLList().addBack(2).addBack(4).addBack(
        6).addBack(8)

    print(display(ListOne.head), display(ListTwo.head))
    print(display(zipSLists2(ListOne, ListTwo)))
    # print(display(new.head))

    # print('Sec max in list with more than one element', secondLargest(new))

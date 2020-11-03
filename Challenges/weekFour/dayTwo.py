from dayOne import SLList, SLNode

# length
# --------------------------------------------------------------------------------------------------
# Create a function that accepts a pointer to first list node, and returns number of nodes in sList.


def length(head):
    count = 0
    index = head
    while (index):
        count += 1
        index = index.next
    return count


# average
# --------------------------------------------------------------------------------------------------
# Create a standalone function average(node) that returns (…wait for it … ) the average of all values contained in that list.


def average(head):
    total = length(head)
    if total == 0:
        return 0
    else:
        sumCount = 0
        index = head
        while (index):
            sumCount += index.value
            index = index.next
        return (sumCount/total)


# min, max
# --------------------------------------------------------------------------------------------------
# Create function min(node) and max(node) to returning smallest and largest values in the list.


def min(head):
    count = 0
    index = head
    minVal = None
    while (index):
        count += 1
        if minVal == None or index.value < minVal:
            minVal = index.value
        index = index.next
    return minVal


def max(head):
    count = 0
    index = head
    maxVal = None
    while (index):
        count += 1
        if maxVal == None or index.value > maxVal:
            maxVal = index.value
        index = index.next
    return maxVal


# display
# --------------------------------------------------------------------------------------------------
# Create display(node) for debugging that returns a string containing all list values. Build what you wish console.log(myList) did!


def display(node):
    string = "["
    index = node
    while (index):
        string += str(index.value)
        if(index.next):
            string += ","
        index = index.next
    string += "]"
    return string


if __name__ == "__main__":
    newList = SLList()
    my_list = SLList()
    my_list.addFront(1).addBack(2).addBack(3)
    print('-' * 90)
    print("The length of empty SLList:", length(newList.head))
    my_list.removeBack()
    my_list.removeBack()
    my_list.addFront(1).addFront(0).addBack(2).addBack(3)
    print("The length of the SLList:", length(my_list.head))

    print('-' * 90)
    print("…wait for it … the average:", average(my_list.head))
    print("…wait for it … the average of empty list:", average(newList.head))

    print('-' * 90)
    print("Min Value:", min(my_list.head))
    print("Max Value:", max(my_list.head))

    print("Min Value of empty:", min(newList.head))
    print("Max Value of empty:", max(newList.head))
    print('-' * 90)
    print("All nodes:", display(my_list.head))
    print("All nodes in empty:", display(newList.head))

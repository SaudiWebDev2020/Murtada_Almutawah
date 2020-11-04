from dayOne import SLList
from dayTwo import display
from dayThree import removeVal,appendVal,prependVal

# Remove Negatives
# ------------------------------------------------------------------------------------
# Given a pointer to the head node of a singly linked list, remove any nodes containing negative values and return the list.

def removeNegatives(sllist):
    index = sllist.head
    while index:
        if(index.value < 0):
            removeVal(sllist,index.value)
        index = index.next

# Partition
# ------------------------------------------------------------------------------------
# Create partition(ListNode, value) that locates the first node with that value, and moves all nodes with values less than that value to be earlier, and all nodes with values greater than that value to be later.  Otherwise, original order need not ve perfectly preserved. return the new head ListNode.

'''
Problems
1. If there is a duplicate less value in the linked list

'''

def partition(ListNode, value):
    index = ListNode.head
    indexOfValue = None
    
    while index:
        if(index.value == value):
            indexOfValue = index
            break
        index = index.next
    
    # print(indexOfValue.next.value,indexOfValue.value)
    
    index2 = ListNode.head
    
    while index2.value:
        if(index2.value > indexOfValue.value):
            # print('Grater',index2.value)
            removed = index2.value
            removeVal(ListNode,index2.value)
            appendVal(ListNode,removed,indexOfValue.value)
            # print(removed)
        if(index2.value == indexOfValue.value):
            break
        index2 = index2.next
        
    
    index3 = indexOfValue
    
    while index3:
        if(index3.value < indexOfValue.value):
            print('Less',index3.value)
            removed = index3.value
            removeVal(ListNode,index3.value)
            prependVal(ListNode,removed,indexOfValue.value)
            # print(removed)
        index3 = index3.next




if __name__ == "__main__":
    my_empty_list = SLList()
    my_single_list = SLList().addFront(-1).addBack(2)
    my_list = SLList().addFront(1).addBack(2).addFront(-1).addBack(-2).addBack(-2)
    my_list_center = SLList().addFront(11).addBack(2).addFront(6).addBack(7).addBack(3).addBack(4).addBack(10).addBack(1).addBack(4)
    
    
    print(display(my_empty_list.head))
    removeNegatives(my_empty_list)
    print(display(my_empty_list.head))
    
    print(display(my_single_list.head))
    removeNegatives(my_single_list)
    print(display(my_single_list.head))
    
    print(display(my_list.head))
    removeNegatives(my_list)
    print(display(my_list.head))
    
    
    print(display(my_list_center.head))
    partition2(my_list_center,4)
    print(display(my_list_center.head))
    
    
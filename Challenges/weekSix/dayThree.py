# Binary String Expansion
# ---------------------------------------------------------------------------------
# You will be given a string containing characters ‘0’, ‘1’, and ‘?’. For every ‘?’, either ‘0’ or ‘1’ characters can be substituted. Write a recursive function that returns an array of all valid strings that have ‘?’ characters expanded into ‘0’ or ‘1’.
# Ex.: binStrExpand("1?0?") should return ["1000","1001","1100","1101"]. For this challenge, you can use string functions such as slice(), etc., but be frugal with their use, as they are expensive.


def binStrExpand(input_str,index=0,return_list= None):
    if return_list == None:
        return_list = []
    # print(index,return_list)
    if len(input_str) == index:
        return return_list
    elif len(return_list) == 0:
        if input_str[index] == '0' or input_str[index] == '1':
            return_list.append(input_str[0:index+1])
            index += 1
            return binStrExpand(input_str,index,return_list)
        else:
            return_list.append('0')
            return_list.append('1')
            index += 1
            return binStrExpand(input_str,index,return_list)
    else:
        if input_str[index] == '0' or input_str[index] == '1':
            for it in range (len(return_list)):
                # print('Here',return_list,input_str[index])
                return_list[it] = f"{return_list[it]}{input_str[index]}"
            index += 1
            return binStrExpand(input_str,index,return_list)
        else:
            newList = []
            for it in range (len(return_list)):
               newList.append(f"{return_list[it]}0")
               newList.append(f"{return_list[it]}1")
            index += 1
            return binStrExpand(input_str,index,newList)
        
def binStrExpand2(input_str,temp_str='',index=0,return_list=None):
    # DONE Another solution
    # print(index,temp_str,input_str)
    if return_list == None:
        return_list = []
    if '?' in input_str:
        if index < len(input_str):
            if input_str[index] == "?":
                binStrExpand2(input_str, temp_str + '1', index + 1, return_list)
                binStrExpand2(input_str, temp_str + '0', index + 1, return_list)
            else:
                binStrExpand2(input_str,temp_str + input_str[index],index + 1,return_list)
        else:
            return_list.append(temp_str)
    else:
        return_list.append(input_str)
    
    return return_list
                


if __name__ == "__main__":
    i1 = binStrExpand("1?0?")
    i2 = binStrExpand("??")
    i3 = binStrExpand("1100")
    # print(i1)
    # print(i2)
    # print(i3)

    x1 = binStrExpand2("1?0?")
    x2 = binStrExpand2("??")
    x3 = binStrExpand2("1100")
    print(x1)
    print(x2)
    print(x3)
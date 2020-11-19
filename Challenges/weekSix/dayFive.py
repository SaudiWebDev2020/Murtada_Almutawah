
def stringAnagrams(string_input,temp="",result=None):
    if result == None:
        result = []
    if len(string_input) > 0:
        for i in range (len(string_input)):
            stringAnagrams(string_input[0:i]+string_input[i+1:len(string_input)],temp + string_input[i],result)
    else:
        # print(temp)
        result.append(temp)
    return result

def stringAnagrams2(string_input,place_hold="",temp="",index=0,result=None):
    print(string_input,temp,index)
    if result == None:
        result = []
        place_hold = string_input
    
    if len(string_input) > index:
        stringAnagrams2(string_input, place_hold[0:index]+place_hold[index+1:len(place_hold)],temp + string_input[index],index + 1,result)
    else:
        print(temp)
        result.append(temp)
        
    return result
        
        
        
        
print(stringAnagrams('abc'))
# print(len(stringAnagrams2('abc')))

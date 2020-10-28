
# Is Palindrome
# --------------------------------------------------------------------------------
# Strings like "Able was I, ere I saw Elba" or "Madam, I'm Adam" could be considered palindromes, because (if we ignore spaces, punctuation and capitalization) the letters are the same from front and back. Create a function that returns a boolean whether the string is a strict palindrome. For "a x a" or "racecar", return true. Do not ignore spaces, punctuation and capitalization: if given "Dud" or "oho!", return false.

def isPalindrome(string):
    reverse = ""
    for i in range(len(string)-1, -1, -1):
        reverse += string[i]
    # print(string == reverse)
    return(string == reverse)


print(isPalindrome("Able was I, ere I saw Elba"))
print(isPalindrome("able was i ere i saw elba"))  # True
print(isPalindrome("Madam, I'm Adam"))
print(isPalindrome("a x a"))  # True
print(isPalindrome("racecar"))  # True
print(isPalindrome("Dud"))
print(isPalindrome("oho!"))

# Longest Palindrome
# --------------------------------------------------------------------------------
# For this challenge, we will look not only at the entire string, but also substrings within it. For a string, return the longest palindromic substring. Given "what up, dada?", return "dad". Given "not much", return "n". Include spaces as well (i.e. be strict, as in the “Is Palindrome” challenge): given "My favorite racecar erupted!", return "e racecar e".


def longestPalindrome(string):
    palList = {}
    for i in range(len(string)):
        # print(i, string[0:i+1])
        for j in range(len(string[0:i + 1])):
            test = string[j:i + 1]
            # print(test)
            if (isPalindrome(test)):
                if len(test) in palList.keys():
                    pass
                else:
                    palList[len(test)] = test
                # palList.append(string[j:i + 1])
    largest = 1
    for key in palList:
        if key > largest:
            largest = key

    # print(palList[largest])
    return(palList[largest])


print(longestPalindrome("not much"))  # n
print(longestPalindrome("what up, dada?"))  # dad
print(longestPalindrome("My favorite racecar erupted!"))  # e racecar e

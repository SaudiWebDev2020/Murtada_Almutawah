# Parens Valid
# ----------------------------------------------------------------------------------------
# Create a function that, given an input string, returns a boolean whether parentheses in that string are valid. Given input "y(3(p)p(3)r)s", return true. Given "n(0(p)3", return false. Given "n)0(t(0)k", return false.


def parensValid(string):
    obj = {
        'starting': ['('],
        'ending': [')']
    }
    print(string)  # obj['starting'][0], obj['ending'][0])

    count = 0
    for char in string:
        if char == obj['starting'][0]:
            count += 1
        elif char == obj['ending'][0]:
            count -= 1
        else:
            pass

        if count < 0:
            return False

    if count == 0:
        return True
    else:
        return False


print(parensValid("y(3(p)p(3)r)s"))
print(parensValid("n(0(p)3"))
print(parensValid("n)0(t(0)k"))
print(parensValid("y(3(p)p(3)r)s)("))


# Braces Valid
# ----------------------------------------------------------------------------------------
# Given a string, returns whether the sequence of various parentheses, braces and brackets within it are valid. For example, given the input string "w(a{t}s[o(n{c}o)m]e)h[e{r}e]!", return true. Given "d(i{a}l[t]o)n{e", return false. Given "a(1)s[O(n]0{t)0}k", return false.

def bracesValid(string):
    print(string)  # listOfLast)  # obj['starting'], obj['ending'])
    obj = {
        'starting': ['(', '{', '['],
        'ending': [')', '}', ']']
    }
    listOfLast = []  # To track last element
    for char in string:
        if char in obj['starting']:
            listOfLast.append((char))
        elif char in obj['ending']:
            before_it = listOfLast.pop()
            if (obj['ending'].index(char) == obj['starting'].index(before_it)):
                pass
            else:
                return False
    return len(listOfLast) == 0


print(bracesValid("w(a{t}s[o(n{c}o)m]e)h[e{r}e]!"))
print(bracesValid("d(i{a}l[t]o)n{e"))
print(bracesValid("a(1)s[O(n]0{t)0}k"))

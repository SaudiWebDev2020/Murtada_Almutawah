# Remove Blanks
# ---------------------------------------------------------------------------------------------
# Create a function that, given a string, returns the string, without blanks. Given " play that
# Funky Music ", returns a string containing "playthatFunkyMusic".

def removeBlanks(givenStr):
    text = ''
    for char in givenStr:
        if not(char.isspace()):
            text += char
    return text


testString1 = ' play that Funky Music '
print(removeBlanks(testString1))


# Get String Digits
# ---------------------------------------------------------------------------------------------
# Create a JavaScript function that given a string, returns the integer made from the string’s
# digits. Given "0s1a3y5w7h9a2t4?6!8?0", the function should return the number 1,357,924,680.


def getStringDigits(givenStr):
    text = ''
    for char in givenStr:
        if char.isdigit():
            text += char
    return int(text)


testString2 = '0s1a3y5w7h9a2t4?6!8?0'
print(getStringDigits(testString2))

# Acronyms
# ---------------------------------------------------------------------------------------------
# Create a function that, given a string, returns the string’s acronym (first letters only,
# capitalized). Given "there's no free lunch - gotta pay yer way", return "TNFL-GPYW". Given
# "Live from New York, it's Saturday Night!", return "LFNYISN".


def acronyms(givenStr):
    text = ''
    traceBool = True
    for char in givenStr:
        if (traceBool and not(char.isspace())):
            text += char
            traceBool = False
        elif (char.isspace()):
            traceBool = True

    return text.upper()


testString3 = 'there\'s no  free lunch - gotta pay yer way'
testString4 = 'Live from New York, it\'s Saturday Night!'
print(acronyms(testString3))
print(acronyms(testString4))

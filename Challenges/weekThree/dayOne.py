# 3!/usr/bin/python3
# -*- coding: utf-8 -*-

# Test if it is python 2 or python 3
# first_name = "Zen"
# last_name = "Coder"
# age = 27
# print(f"My name is {first_name} {last_name} and I am {age} years old.")

# Arrs2Map
# ----------------------------------------------------------------------------------------------------------------
# Given two arrays, create an associative array(map) containing keys of the first, and values of the
# second. For arr1 = ["abc", 3, "yo"] and arr2 = [42, "wassup", true], return {"abc":
# 42, 3: "wassup", "yo": true}.


def arrs2Map(arr1, arr2):
    print(arr1, arr2)
    obj = {}
    for index in range(0, len(arr1)):
        obj[arr1[index]] = arr2[index]
    return obj


# DONE Ask about the length = > Depending on the needs.
# for the first one we will not have any problem
# for the second one we will have one undefined key for all.

testArr1 = ["abc", 3, "yo"]
testArr2 = [42, "wassup", True]
print(arrs2Map(testArr1, testArr2))

# InvertHash
# ----------------------------------------------------------------------------------------------------------------
# Create invertHash(assocArr) that converts a hash’s keys to values and values to corresponding keys.
# Example: given {"name": "Zaphod","numHeads": 2}, return {"Zaphod": "name"2 "numHeads"}.
# You will need to learn and use a JavaScript for ... in h ere!
# Clarifying Question ! do you want me to return the same object or return another solution.

# TODO Edit the same arr ?


def invertHash(obj):
    newObj = {}
    for item in obj:
        newObj[obj[item]] = item
    return newObj


testObj = {"name": "Zaphod", "numHeads": 2}
print(testObj)
print(invertHash(testObj))

# print(invertHash2(testObj))

# ReverseString
# ----------------------------------------------------------------------------------------------------------------
# Implement a function reverseString(str) that, given a string, will return the string of the same length but
# with characters reversed. Example: given "creature", return "erutaerc". Do not use the built-in
# reverse() function!


# FIXME Backword
def reverseString(givenStr):
    newStr = ""
    for c in givenStr:
        newStr += c
    return newStr


# Another solution in forword way


def reverseString2(givenStr):
    newStr = ""
    for c in givenStr:
        newStr = c + newStr
    return newStr


testStr = 'creature'
print(testStr)
print(reverseString(testStr))
print(reverseString2(testStr))

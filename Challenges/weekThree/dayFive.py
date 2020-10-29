# Book Index
# ------------------------------------------------------------------------
# Write a function that given a sorted array of page numbers, return a string representing a book index. Combine consecutive pages to create ranges. Given [1, 3, 4, 5, 7, 8, 10], return the string "1, 3-5, 7-8, 10".

def bookIndex(arr):
    string = ""
    start = arr[0]
    last = arr[0]
    for item in range(1, len(arr)):
        # print(arr[item])
        end = arr[item]
        if end - arr[item-1] == 1:
            # print(start, end)
            last = end
        else:
            if last > start:
                string += f"{str(start)} - {last}, "
                # last = None
            else:
                string += f"{str(start)},"
            start = end
        # print(string)

    if end > start:
        string += f"{str(start)} - {end}."
        # last = None
    else:
        string += f"{str(end)}."

    return string


print(bookIndex([1, 3, 4, 5, 7, 8, 10, 11, 12]))
print(bookIndex([1, 5, 6, 7, 8, 9, 10, 15]))

# Common Suffix
# ------------------------------------------------------------------------
# When given an array of words, returns the largest suffix (word-end) that is common between all words. For example, for input ["ovation", "notation", "action"], return "tion". Given ["nice", "ice", "sic"], return "".


def commonSuffix(arr):
    commenString = ""
    first = arr[0]
    # for item in arr:
    #     if len(item) > len(first):
    #         first = item
    # print(first)
    for i in range(len(first) - 1, -1, -1):
        lastChar = first[i]
        for item in arr:
            if item[len(item) - len(commenString) - 1] != lastChar:
                # print("Stop")
                return commenString
        commenString = lastChar + commenString
    # print(first, lastChar, commenString)

    return commenString


print("The common suffix:", commonSuffix(["ovation", "notation", "action"]))
print("The common suffix:", commonSuffix(["nice", "ice", "sic"]))
print("The common suffix:", commonSuffix(["sick", "sick", "sick"]))
print("The common suffix:", commonSuffix(["ksic", "sic", "sic"]))
print("The common suffix:", commonSuffix(["sic", "kksic", "ksic"]))

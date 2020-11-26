// 1. Biggie Size - Given an array, write a function that changes all positive numbers in the array to the string "big".  Example: makeItBig([-1,3,5,-5]) returns that same array, changed to [-1, "big", "big", -5].
function biggieSize(arr) {
    for (var i = 0; i < arr.length; i++){
        if (arr[i] > 0) {
        arr[i] = 'big';
        }
    }
    return arr;
}

// console.log(biggieSize([-1,3,5,-5]));

// 2. Print Low, Return High - Create a function that takes in an array of numbers.  The function should print the lowest value in the array, and return the highest value in the array.

function printLowReturnHigh(arr) {
    var max = arr[0];
    var min = arr[0];

    for (var i = 0; i < arr.length; i++) {
        if (max < arr[i]) {
            max = arr[i];
        } else if (min > arr[i]) {
            min = arr[i];
        }
    }

    console.log(min);
    return max;

}

// console.log(printLowReturnHigh([-1,3,5,-5]));


// 3. Print One, Return Another - Build a function that takes in an array of numbers.  The function should print the second-to-last value in the array, and return the first odd value in the array.
function printOneReturnAnother(arr) {
    var firstOddValue; 
    var startingToPrint = 1;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] % 2 == 1 && firstOddValue == null) {
            firstOddValue = arr[i];
        } 
        if (i >= startingToPrint) {
            console.log(arr[i]);
        }
    }
    return firstOddValue;
}


// var testArr = [1, 2, 3];
// console.log("First odd",printOneReturnAnother(testArr));
// console.log(testArr);


// 4. Double Vision - Given an array (similar to saying 'takes in an array'), create a function that returns a new array where each value in the original array has been doubled.  Calling double([1,2,3]) should return [2,4,6] without changing the original array.

function doubleVision(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr.push(arr[i] * 2);
    }

    return newArr;
}

// var testArr = [1, 2, 3];
// console.log(doubleVision(testArr));
// console.log(testArr);


// 5. Count Positives - Given an array of numbers, create a function to replace the last value with the number of positive values found in the array.  Example, countPositives([-1,1,1,1]) changes the original array to [-1,1,1,3] and returns it.

function countPositives(arr) {
    
    var count = 0;
    for (var i = 0; i < arr.length; i++){
        if (arr[i] >= 0) {
            count++;
        }
    }
    arr[arr.length - 1] = count;
    return arr;
}

// var testArr = [-1, 1, 1, 1];
// console.log(countPositives(testArr));
// console.log(testArr);

// 6. Evens and Odds - Create a function that accepts an array.  Every time that array has three odd values in a row, print "That's odd!".  Every time the array has three evens in a row, print "Even more so!".

function evensAndOdds(arr) {
    var oddCount = 0;
    var evenCount = 0;
    for (var i = 0; i < arr.length; i++){
        // console.log(i, oddCount, evenCount);
        if (arr[i] % 2 == 1) {
            oddCount++;  
            evenCount = 0;
        }
        else if (arr[i] % 2 == 0){
            evenCount++;
            oddCount = 0;
        }
        
        if (oddCount % 3 == 0 && oddCount > 0) {
            console.log("That's odd!");
        }

        if (evenCount % 3 == 0 && evenCount > 0) {
            console.log("Even more so!",evenCount);
            
        }
    }

    // return arr;
}

// var testArr = [1, 1, 2, 3,7,7,7,5,5,4,6];
// console.log(testArr);
// console.log(evensAndOdds(testArr));



// 7. Increment the Seconds - Given an array of numbers arr, add 1 to every other element, specifically those whose index is odd (arr[1], arr[3], arr[5], etc).  Afterward, console.log each array value and return arr.

function incrementTheSeconds(arr) {
    for (var i = 0; i < arr.length; i++){
        if (i % 2 == 1) {
            arr[i]++;
        }
    }
    // console.log(arr);
    // return arr;
}

// var testArr = [1,2,3,4];
// console.log(incrementTheSeconds(testArr));
// console.log(testArr);


// 8. Previous Lengths - You are passed an array (similar to saying 'takes in an array' or 'given an array') containing strings.  Working within that same array, replace each string with a number - the length of the string at the previous array index - and return the array.  For example, previousLengths(["hello", "dojo", "awesome"]) should return ["hello", 5, 4]. Hint: Can for loops only go forward?

function previousLengths(arr) {
    for (var i = arr.length - 1; i > 0; i--){
        arr[i] = arr[i - 1].length;
    }
    return arr;
}

// var testArr = ["hello", "dojo", "awesome"];
// console.log(previousLengths(testArr));

// 9. Add Seven - Build a function that accepts an array. Return a new array with all the values of the original, but add 7 to each. Do not alter the original array.  Example, addSeven([1,2,3]) should return [8,9,10] in a new array.

function addSaven(arr) {
    var v = 7;
    var newArr = [];
    for (var i = 0; i < arr.length; i++){
        newArr[i] = arr[i] + v;
    }
    return newArr;
}

// var testArr = [1,2,3];
// console.log(addSaven(testArr));
// console.log(testArr);


// 10. Reverse Array - Given an array, write a function that reverses its values, in-place.  Example: reverse([3,1,6,4,2]) returns the same array, but now contains values reversed like so... [2,4,6,1,3].  Do this without creating an empty temporary array.  (Hint: you'll need to swap values).


function reverse(arr) {
    for (var i = 0; i < arr.length / 2; i++){
        temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
    return arr;
}

// var testArr = [3, 1, 6, 4, 2];
// console.log(testArr);
// console.log(reverse(testArr));
// console.log(testArr);


// 11. Outlook: Negative - Given an array, create and return a new one containing all the values of the original array, but make them all negative (not simply multiplied by -1). Given [1,-3,5], return [-1,-3,-5].

function outlookNegative(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++){
        if (arr[i] < 0) {
            newArr[i] = arr[i];  
        } else {
            newArr[i] = arr[i] * -1; 
        }
    }
    return newArr;
}

// var testArr = [1,-3,5];
// console.log(testArr);
// console.log(outlookNegative(testArr));
// console.log(testArr);

// 12. Always Hungry - Create a function that accepts an array, and prints "yummy" each time one of the values is equal to "food".  If no array values are "food", then print "I'm hungry" once.

function alwaysHungry(arr) {
    // This method is case sensetive =). 
    var eatFood = false;
    for (var i = 0; i < arr.length; i++){
        if (arr[i] == 'food') {
            if (!eatFood) {
                eatFood = true;
            }
            console.log("yummy");
        }
    }

    if (!eatFood) {
        console.log("I'm hungry");
    }
    // console.log(arr);
    // return arr;
}


// var testArr = [true,42,"food","Food",'food',"pizza"];
// console.log(testArr);
// alwaysHungry(testArr);

// 13. Swap Toward the Center - Given an array, swap the first and last values, third and third-to-last values, etc.  Example: swapTowardCenter([true,42,"Ada",2,"pizza"]) turns the array into ["pizza", 42, "Ada", 2, true].  swapTowardCenter([1,2,3,4,5,6]) turns the array into [6,2,4,3,5,1].  No need to return the array this time.

function swapTowardCenter(arr) {
    for (var i = 0; i < arr.length / 2; i++){
        if (i % 2 == 0) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    // console.log(arr);
    // return arr;
}

// var testArr = [true,42,"Ada",2,"pizza"];
// var testArr2 = [1, 2, 3, 4, 5, 6];
// console.log(testArr);
// console.log(testArr2);
// console.log(swapTowardCenter(testArr));
// console.log(swapTowardCenter(testArr2));
// console.log(testArr);
// console.log(testArr2);


// 14. Scale the Array - Given an array arr and a number num, multiply all values in the array arr by the number num, and return the changed array arr.  For example, scaleArray([1,2,3], 3) should return [3,6,9].

function scaleTheArray(arr,num) {
    for (var i = 0; i < arr.length; i++){
        arr[i] *= num;  
    }
    return arr;
}

// var testArr = [1,2,3];
// console.log(testArr);
// console.log(scaleTheArray(testArr,3));
// console.log(testArr);
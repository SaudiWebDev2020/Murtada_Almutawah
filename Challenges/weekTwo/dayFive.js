// MostFrequentNumber
// ------------------------------------------------------------------------
// Given an array of interfers containing duplicates,return the majority element in the array if Present.
// Input = [2,8,7,2,2,5,2,3,1,2,2]
// Output = 2
// Another sulotuin 2) We can use objects where the key will be the number and the value is the number of times it is found. 

function MostFrequentNumber(arr) {
    var newArr=[];
    for (var i = 0; i < arr.length; i++){
        counter = 1;
        for (var j = i + 1; j < arr.length; j++){
            if (arr[i] === arr[j]) {
                counter++;
            }  
        }
        newArr[i] = counter;
        // console.log(newArr, counter);
    }
    console.log(newArr);
    index = 0;
    for (var x = 1; x < arr.length; x++){
        if (newArr[index] < newArr[x]) {
            index = x;
        }
    }
    console.log(arr[index]);
}

// DONE: Another Solution using object to store the key & value which will solve the duplication issue in the first solution. 

function MostFrequentNumberUsingObject(arr) {
    var tempObj = {};
    for (var i = 0; i < arr.length; i++){
        counter = 1;
        for (var j = i + 1; j < arr.length; j++){
            if (arr[i] === arr[j]) {
                counter++;
            }
        }
        if (tempObj[arr[i]] < counter || tempObj[arr[i]] == undefined) {
            tempObj[arr[i]] = counter;
        }
    }
    // console.log(tempObj);

    index = 0;
    var max;
    for (var item in tempObj) {
        if (tempObj[item] > max || max == undefined) {
            index = item;
            max = tempObj[item];
        }
        // console.log('key',tempObj[item],max);
    }
    console.log('number',index,":",tempObj[index]);
}


var testArr = [-1,-1,-1,3, -1, -1, 8, 7, 2, 2, 5, 2, 3, -1, 2, 2];
// MostFrequentNumber(testArr);
MostFrequentNumberUsingObject(testArr);

// Number of Steps to Reduce a Number to Zero
// // ------------------------------------------------------------------------
// Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
// Example
// Input: num = 8
// Output: 4
// Explanation: 
// Step 1) 8 is even; divide by 2 and obtain 4. 
// Step 2) 4 is even; divide by 2 and obtain 2. 
// Step 3) 2 is even; divide by 2 and obtain 1. 
// Step 4) 1 is odd; subtract 1 and obtain 0.

function reduction(num) {
    var steps = 1;
    while (num > 0) {
        if (num % 2 == 0) {
            console.log("Step %d) %d is even; devided by 2 and obtain %d",steps,num, num / 2);
            num /= 2;
        } else {
            console.log("Step %d) %d is odd; subtracting 1 and obtain %d", steps, num, num - 1);
            num--;
        }
        steps++;
    }
}

// reduction(8);
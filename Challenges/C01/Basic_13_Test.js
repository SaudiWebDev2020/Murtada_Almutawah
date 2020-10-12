// Murtada Almutawah


function print1To255() {
    // Print all the integers from 1 to 255.
    for (var count = 1; count < 256; count++) {
        console.log(count);
    }
}

function printIntsAndSum0To255() {
    // Print integers from 0 to 255, and with each integer print the sum so far.
    var sum = 0;
    for (var count = 0; count < 256; count++) {
        sum += count;
        console.log(count, "The sum so far", sum);
    }
}


function printMaxOfArray(arr) {
    // Given an array, find and print its largest element.

    var max = arr[0];
    for (var count = 1; count < arr.length; count++) {
        if (max < arr[count]) {
            max = arr[count];
        }
    }
    console.log("The max of the array", max);
}


function returnOddsArray1To255() {
    // Create an array with all the odd integers between 1 and 255 (inclusive).
    var oddList = [];
    for (var count = 1; count < 256; count++) {
        if (count % 2 == 1) {
            oddList.push(count);
        }
    }
    return oddList;
}
//Return Odds Array 1-255
// console.log(returnOddsArray1To255());

function returnArrayCountGreaterThanY(arr, y) {
    //Given an array and a value Y, count and print the number of array values greater than Y.
    var arrayGrater = [];
    for (var count = 1; count < arr.length; count++) {
        if (arr[count] > y) {
            arrayGrater.push(arr[count]);
        }
    }
    return (arrayGrater);
}

var array1 = [-10, 0, 9, -9, 10, 14];
// console.log(returnArrayCountGreaterThanY(array1, 8));

//console.log(printMaxOfArray(array1));

function printMaxMinAverageArrayVals(arr) {
    //Given an array, print the max, min and average values for that array.
    var max = arr[0], min = arr[0];
    var sum = 0;
    for (var count = 1; count < arr.length; count++) {
        if (max < arr[count]) {
            max = arr[count];
        } else if (min > arr[count]) {
            min = arr[count];
        }
        sum += arr[count];
    }
    console.log("Max =", max, "Min =", min, "Avarage = ", (sum / arr.length));
}

// printMaxMinAverageArrayVals(array1);


function swapStringForArrayNegativeVals(arr) {
    // Given an array of numbers, replace any negative values with the string 'Dojo' .
    for (var count = 0; count < arr.length; count++) {
        if (0 > arr[count]) {
            arr[count] = 'Dojo';
        }
    }
    return arr;
}

//printMaxOfArray(array1);

// console.log(swapStringForArrayNegativeVals(array1));

function printOdds1To255() {
    //Print all odd integers from 1 to 255.
    for (var count = 1; count < 256; count++) {
        if (count % 2 == 1) {
            console.log(count);
        }
    }
}

// printOdds1To255()


function printArrayVals(arr) {
    // Iterate through a given array, printing each value.
    for (var count = 0; count < arr.length; count++) {
        console.log(arr[count]);
    }
}

function printAverageOfArray(arr) {
    // Analyze an array’s values and print the average.
    var sum = 0;
    for (var count = 0; count < arr.length; count++) {
        sum += arr[count];
    }
    console.log("Avarage = ", (sum / arr.length));
}

// printAverageOfArray(array1);

function squareArrayVals(arr) {
    // Square each value in a given array, returning that same array with changed values.
    for (var count = 0; count < arr.length; count++) {
        arr[count] = arr[count] * arr[count];
    }
    return arr;
}

// console.log(squareArrayVals(array1));

function zeroOutArrayNegativeVals(arr) {
    //Return the given array, after setting any negative values to zero.
    for (var count = 0; count < arr.length; count++) {
        if (0 > arr[count]) {
            arr[count] = 0;
        }
    }
    return arr;
}

function shiftArrayValsLeft(arr) {
    // Given an array, move all values forward (to the left) by one index, dropping the first value and leaving a 0 (zero) value at the end of the array.
    for (var count = 0; count < arr.length - 1; count++) {
        arr[count] = arr[count + 1];
    }
    arr[arr.length - 1] = 0;
    return arr;
}

// console.log(array1);

// console.log(shiftArrayValsLeft(array1));
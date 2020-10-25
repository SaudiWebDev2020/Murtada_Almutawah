// Second-Largest
// -------------------------------------------------------
// Return the second-largest element of an array
// DONE Solve

function secondLargest(arr) {
    if (arr.length > 1) {
        arr.sort(function (a, b) { return a - b;});
        return arr[arr.length - 2];
    } else {
        return null;
    }
}

// testArr = [1, 2, 3, 6, 2, 10, 19];
// console.log(secondLargest(testArr));

// Nth-Largest
// -------------------------------------------------------
// Given an array, return the Nth-largest element:
// there should be (N - 1) elements that are larger.
// DONE Test the functionality.

function nthLargest(arr, n) {
    if (arr.length > n-1) {
    arr.sort(function (a, b) {
        return a - b;
    });
    return arr[arr.length - n];
    } else {
        return null;
    }
}

// testArr = [1, 2, 3, 6, 2, 10,19];
// console.log(nthLargest(testArr, 4));
// console.log(testArr);

// Shuffle
// -------------------------------------------------------
// Recreate the shuffle()built into JavaScript, to
// efficiently shuffle a given array’s values. Do you
// need to return anything from your function?
// DONE Solve

function shuffle(arr) {
    var temp,randomIndex;
    for (var i = 0; i < arr.length; i++){
        temp = arr[i];
        randomIndex = Math.floor(Math.random()*(arr.length-1));
        arr[i] = arr[randomIndex];
        arr[randomIndex] = temp;
    }
    return arr;
}

// testArr = [1, 2, 3, 6, 2, 10, 19];
// console.log(testArr);
// console.log(shuffle(testArr));
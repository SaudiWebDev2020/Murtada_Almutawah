// Second-Largest
// -------------------------------------------------------
// Return the second-largest element of an array
// TODO Solve



// Nth-Largest
// -------------------------------------------------------
// Given an array, return the Nth-largest element:
// there should be (N - 1) elements that are larger.
// TODO Test the functionality.

function nthLargest(arr, n) {
    arr.sort();
    return arr[arr.length - n];
}

testArr = [1, 2, 3, 6, 2, 10,19];
console.log(nthLargest(testArr, 1));
console.log(testArr);

// Shuffle
// -------------------------------------------------------
// Recreate the shuffle()built into JavaScript, to
// efficiently shuffle a given array’s values. Do you
// need to return anything from your function?
// TODO Solve

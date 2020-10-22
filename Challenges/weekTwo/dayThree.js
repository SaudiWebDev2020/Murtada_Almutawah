// Binary Search
// ------------------------------------------------------------
// Given a sorted array and a value, return whether
// that value is present in the array. Do not
// sequentially iterate the entire array. Instead,
// ‘divide and conquer’, taking advantage of the fact
// that the array is sorted.

function binarySearch(arr, val) {
    // console.log(arr, val);
    var start = 0;
    var end = arr.length - 1;
    // var middle = (end + start) / 2;
    // console.log(middle);
    // console.log(arr[middle])
    while (start <= end) {
        middle = Math.floor((end + start) / 2);
        // console.log(start, end, middle);
        if (arr[middle] == val) {
            // break 
            return middle;
        }
        
        if (arr[middle] < val) {
            start = middle + 1;

        } else if (arr[middle] > val) {
            end = middle - 1;
        }

        // console.log(start, end, middle);
    }
    return -1;
    

}

testArr = [2, 40, 50, 99, 1000];
console.log( binarySearch(testArr, 1000));
console.log( binarySearch(testArr, 2));
console.log( binarySearch(testArr, 50));
console.log( binarySearch(testArr, 90));
console.log( binarySearch(testArr, 99));


// Pairs to Sum
// ------------------------------------------------------------
// How do you find all pairs of an integer array whose sum is equal to a given number?

function pairsToSum(arr,num) {
    var pairs = [];
    for (var i = 0; i < arr.length; i++){
        for (var j = i + 1; j < arr.length; j++){
            if (arr[i] + arr[j] == num) {
                pairs.push([arr[i], arr[j]]);
            }
        }
    }
    console.log(pairs);
    return pairs;
}


// pairsToSum([3, 8, 5, 1, 8, 7, 3, 4, 0], 8);
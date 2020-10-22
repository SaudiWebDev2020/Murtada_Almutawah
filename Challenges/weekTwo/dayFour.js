// Find maximum product of two integers in an array
// ---------------------------------------------------------------------------------
// Given an array of integers, find maximum product of two intefegs in an array
// input = [4,7,2,9,5]
// output = 63 (7*9)
// input =[5,-4,2,6,-8]
// output = 32 (-8*-4)

function maxProduct(arr) {
    arr.sort(function (a, b) {
        return a - b;
    });
    first = arr[0] * arr[1];
    secend = arr[arr.length - 1] * arr[arr.length - 2];

    if (first > secend){
        return first;
    } else if (secend > first){
        return secend;
       } 
    
    return arr;
}


console.log(maxProduct([4, 7, 2, 9, 5]));
console.log(maxProduct([5, -4, 2, 6, -8]));
console.log(maxProduct([5, -4, -9, -7, -8]));
console.log(maxProduct([5, 0, -9, 7, 8]));


// Move all zeros present in an array to the end
// ---------------------------------------------------------------------------------
// Given an array of intefers, move all zeros present in the array to the end.  The solution should maintain the relative order of items in the array.
// input = [6,0,8,2,3,4,0,4,0,1]
// output = [6,8,2,3,4,4,1,0,0,0]

function moveZeros(arr) {
    var num = 0;
    for (var i = 0; i < arr.length; i++){
        if (arr[i] == 0) {
            num++;
        } else {
            arr[i-num] = arr[i];
        }
        // console.log(arr);
    }
    if (num > 0) {
        for (var x = arr.length - 1; x > 0 & num > 0; x--) {
            arr[x] = 0;
            num--;
        }
    }
    return arr; 
}


// console.log(moveZeros([6, 0, 8, 2, 3, 4, 0, 4, 0, 1]));
// console.log(moveZeros([6, 0, 8, 2, 3]));
// console.log(moveZeros([0,0,0,0,0]));
// console.log(moveZeros([0,0,0,0,1]));
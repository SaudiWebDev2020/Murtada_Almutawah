// Reverse Array
// -----------------------------------------------------
// Given a numerical array, reverse the order of the
// values. The reversed array should have the same
// length, with existing elements moved to other
// indices so that the order of elements is reversed.

function reverseArray(arr) {
    var r = arr.length-1;
    for (var x = 0; x < arr.length; x++){
        if (x != r && x < r) {
            temp = arr[x];
            arr[x] = arr[r];
            arr[r] = temp;
            console.log(arr, x, r);
            r--;
        }
    }
    //console.log(arr)
    return arr;
}

arr1 = [1, -3, 0,4];
// 20, 0, 100, 7, -11 , 0, -3, 1
//console.log(arr1);
reverseArray(arr1);
console.log(arr1);

// Remove Negatives
// -----------------------------------------------------
// Implement a function removeNegatives() that
// accepts an array and removes any values that
// are less than zero.
// Second-level challenge: don’t use nested loops.

function removeNegatives(arr) {
    var count = 0;
    for (var trac = 0; trac < arr.length; trac++){
        if (arr[trac] < 0) {
            count++;
        }
        arr[trac] = arr[trac + count];
    }
    //console.log(arr,count);
    arr.length -= count;
    return arr;
}


//arr1 = [1, -3, 0, -11];
//removeNegatives(arr1);
//console.log(arr1);



// Skyline Heights
// -----------------------------------------------------
// You are given an array with heights of consecutive buildings in the city. For example, [-1,7,3] would
// represent three buildings: first is actually below street level, second is seven stories high, and third is
// three stories high (but hidden behind the seven-story onbe). You are situated at street level. Return an
// array containing heights of the buildings you can see, in order. Given [1,-1,7,3] return [1,7].

function skylineHeights(arr) {
    var max = 0;
    var count = 0;
    for (var trac = 0; trac < arr.length; trac++){
        if (arr[trac] < max) {
            count++;
        } else {
            max = arr[trac];
            arr[trac - count] = arr[trac];
        }
    }
    console.log(arr,count);
    arr.length -= count;
    return arr;
}

//arr1 = [1, -3, 0, -11,7,100, 0, 20];
//skylineHeights(arr1);
//console.log(arr1);
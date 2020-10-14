// Rotate Array
// -----------------------------------------------------
// Implement rotateArr(arr, shiftBy) that
// accepts array and offset. Shift arr’s values to the
// right by that amount. ‘Wrap-around’ any values
// that shift off array’s end to the other side, so that
// no data is lost. Operate in-place: given
// ([1,2,3],1), change the array to [3,1,2].


function rotateArr(arr, shiftBy) {
    //
    
    numOfroutations = shiftBy % arr.length;
    console.log("Rotate: ",numOfroutations);
    for (var x = 0; x < numOfroutations; x++){

        temp = arr[arr.length-1] 
        for (var y = arr.length -1; y > 0 ; y--){
            arr[y] = arr[y - 1];
        }
        arr[0] = temp;
    }

    return arr;
}

arr3 = [0, 1, 2]
console.log(rotateArr(arr3, 7));
console.log("Min = ",minOfSorted(arr3));




// Optionally, add these advanced features:
//     a) allow a negative shiftBy (shift left, not right),
//     b) minimize memory usage. With only a few local
//         variables (not an array), handle arrays and
//         shiftBys in the millions,
//     c) minimize how many touches of each element.



// Min Of Sorted-Rotated
// -----------------------------------------------------
// You will be given a numerical array that has first
// been sorted, then rotated by an unknown
// amount. Find and return the minimum value in
// that array.

function minOfSorted(arr) {
    x = 0;
    do {
        first = arr[x];
        second = arr[x +1];
        if (first > second) {
            return second;
        } else {
            x++;
        }
        // console.log("count",x);
    } while (x < arr.length);

    return [arr[0]];
}

//arr1 = [0, 1, 2, 3, 4, 5, 6];
//console.log(minOfSorted(arr1));

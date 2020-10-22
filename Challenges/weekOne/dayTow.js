// Today's Algo challenges (Do not use any built in JS methods):
//  Array: Push Front
function pushFront(arr, val) { 
    //insertAt(arr, 0, val);
    for (var count = arr.length; count > 0; count--){
        arr[count] = arr[count - 1];
    }    
    arr[0] = val;

}

//  Array: Pop Front, remove and return first val
function popFront(arr) {
    var val = arr[0];
    for (var x = 0; x < arr.length; x++) {
            arr[x]= arr[x+1];
    }
    arr.length--;
    return val;
}

//  Array: Insert At, insert at the index
function insertAt(arr, index, val) { 
    // val = 10 
    // [0, 1, < 10 >,  2, 3]
    for (var x = arr.length; x > index; x--) {
        arr[x] = arr[x - 1];
    }
    arr[index] = val;

    }
// ([], 0, 1)
//  Array: Remove At
function removeAt(arr, index) { 

    var val = arr[index];
    for (var x = index; x < arr.length; x++) {
            arr[x]= arr[x+1];
    }
    arr.length--;

    return val;
}

// Example 
var arr1 = [];

pushFront(arr1, 3);
pushFront(arr1, 2);
pushFront(arr1, 1);
pushFront(arr1, 0);

console.log(arr1); // 0,1,2,3

popFront(arr1);
popFront(arr1);
popFront(arr1);
popFront(arr1);


insertAt(arr1, 0, 300);
insertAt(arr1, 0, 200);
insertAt(arr1, 0, 100);

removeAt(arr1, 1);

console.log(arr1);


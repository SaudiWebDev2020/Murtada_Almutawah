
/*
// It has issue with going with random pivot
function partition(arr,left,right) {
    let pivot = Math.floor(Math.random()*arr.length);
    // let pivot = Math.floor((left+right)/2);
    // let pivot = left;
    let val_pivot = arr[pivot];
    
    // console.log('Before','pivot',pivot,'val',arr[pivot],'arr',arr);

    while (left < right ){
        // console.log(left,pivot,right,arr);
        while(arr[left] < val_pivot){
            // console.log(arr[left],'<',arr[pivot])
            left++;
        }
        while(arr[right] > val_pivot){
            right--;
        }
        
        if (left<right){
            // console.log('swap',arr[left],arr[right],arr[pivot]);
            [arr[right],arr[left]] = [arr[left],arr[right]];
            // right--;    
            // left++;
            }
        }

    // console.log('After','pivot',pivot,'val',arr[pivot],'left',left,'arr',arr);

    console.log('Returned',left);
    return left;
}

// Another answer.
function quickSort(arr, left, right) {
    if (left < right) {
    const index = partition(arr, left, right);
    quickSort(arr, left, index);
    quickSort(arr, index + 1, right);
    }
}

*/


function partition(arr,left,right){
    const pivot = arr[Math.floor((left+right)/2)];
    // console.log(right-left);
    // const pivot = arr[Math.floor(Math.random()*(right-left))];
    while (true) {
        while (arr[left] < pivot) {
        left++;
        }

        while (arr[right] > pivot) {
        right--;
        }

        if (left >= right) {
        return right;
        }
        
        // swap(arr, left, right);
        [arr[left],arr[right]] = [arr[right],arr[left]];
    }
}


function rQuickSort(arr,left,right){
    left =  left || 0;    
    right =  right || arr.length-1 ;

    var pivot = partition(arr,left,right);

    if (left<pivot){
        // console.log(arr,left,pivot);
        rQuickSort(arr,left,pivot-1);
    }
    if (right > pivot){
        // console.log('right to left',arr,pivot+1,right);
        rQuickSort(arr,pivot+1,right);
    }
    // console.log(arr);
    return arr;
}


arr  = [5,1,6,4,2];
arr2 = [4,8,5,7,1,6,10,2,3,9];
arr3 = [4,8,5,7,1,6,10,2,3];
arr5 = [5,1,6,4,2,3];

console.log(rQuickSort(arr));
console.log(rQuickSort(arr2));
console.log(rQuickSort(arr3));
console.log(rQuickSort(arr5));


// console.log(arr)
// console.log(arr2)
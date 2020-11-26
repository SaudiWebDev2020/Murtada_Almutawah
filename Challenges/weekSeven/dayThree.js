function combineArrays(arr1, arr2) {
    const arr3 = [];
    // your code here
    let i = 0;
    let j = 0; 
    
    while(i<arr1.length || j < arr2.length){
        if (i>=arr1.length){
            arr3.push(arr2[j]);
            j++;
        } else if (j>=arr2.length){
            arr3.push(arr1[i]);
            i++;
        }
        else if (arr1[i] < arr2[j]){
            arr3.push(arr1[i]);
            i++;
        }else if(arr1[i]>arr2[j]) {
            arr3.push(arr2[j]);
            j++;
        }

    }
    return arr3;
}

// console.log(combineArrays([2,5], [1,4,6,8]));
// this should result in [1, 2, 4, 5, 6, 8]

// my solution :: not complete =<. 
function mergeSort(arr,length = arr.length,result=[]) {
    // your code here
    console.log(arr)
    // Devide
    if(result.length<length){
        if (arr.length <= 1){
            // console.log(arr[0]);
            result.push([arr[0]]);
        } else{
            var mid = Math.floor(arr.length/2);
            // let left = arr.slice(0,mid);
            // let right = arr.slice(mid,arr.length);
            // console.log(mid,left,right)
            mergeSort(arr.slice(0,mid),length,result);
            mergeSort(arr.slice(mid,arr.length),length,result);
        }
    }
    
    if (result.length == length){
        concer = [];
        while(result.length>1){
            for(let i =0; i<result.length;i++){

            }
            a1 = result.pop();
            a2 = result.pop();
            u = combineArrays(a1,a2);
            console.log(u);
        }
    }



    return result;
}

// instructor approach.
function mergeSort1(arr) {
    // your code here
    console.log(arr);

    if (arr.length < 2){
        return arr;
    }
    var mid = Math.floor(arr.length/2);
    const left = mergeSort1(arr.slice(0,mid));
    const right = mergeSort1(arr.slice(mid,arr.length));
    return combineArrays(left,right);
}

// console.log(mergeSort([3,2,5,4,1]));
console.log(mergeSort1([3,2,5,4,1]));
function bubbleSort(arr) {
    for(var k = 0;k<arr.length;k++){
        // Add flag to brake if inOrder
        let inOrder = true;

        for(var i = 0;i<arr.length-k;i++){
            if(arr[i]>arr[i+1]){
                // temp = arr[i+1];
                // arr[i+1]=arr[i];
                // arr[i]=temp;
                [arr[i+1],arr[i]] = [arr[i],arr[i+1]];
                inOrder = false;
            }
        }
        if (inOrder){
            return arr;
        }
    }

    return arr;
}

console.log(bubbleSort([3,2,5,4,1]));


function selectionSort(arr) {
    for(var k = 0;k<arr.length;k++){
        
        min_index = k;

        for(var i = min_index+1;i<arr.length;i++){
            if(arr[i] < arr[min_index]){
                min_index = i;
            }
        }

        if (min_index != k){
            temp = arr[k];
            arr[k] = arr[min_index];
            arr[min_index] = temp;
        }

    }
    return arr;
}

console.log(selectionSort([3,2,5,4,1]));
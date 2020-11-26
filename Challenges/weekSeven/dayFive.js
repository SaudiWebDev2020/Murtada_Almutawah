function findMax(arr){
    let max = arr[0];
    for(let index=1;index<arr.length;index++){
        if(arr[index]>max){
            max=arr[index];
        }
    }
    // console.log(max);
    return max==undefined ? '' : max;
}

function radixSort(arr){

    let rad = 10;
    let dev = 1;
    let counter = 0;

    let max = findMax(arr);
    let expLength = String(max).length;

    while (counter<expLength){
        // console.log(expLength,counter);
        let buckets = [[],[],[],[],[],[],[],[],[],[]];

        // destrebute the arr
        while(arr.length > 0){
            poped = arr[0];
            arr.shift();
            let index = Math.floor((poped%rad)/dev);
            // console.log(index);

            buckets[index].push(poped);
        }
        
        // Return to the arr
        for(let index = 0; index<10;index++){
            for(let j = 0; j<buckets[index].length;j++){
                arr.push(buckets[index][j]);
            }
        }

        rad = rad * 10;
        dev = dev * 10;
        counter++;

        // console.log(arr);
        // console.table(buckets);
    }
    return arr;
}


arr1 = [121, 20, 12, 3333, 15, 9];
console.log(arr1);
console.log(radixSort(arr1));
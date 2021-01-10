function insertionSort(arr) {

    for (let i = 0;i<arr.length;i++){ // start
        for (let j = i; i > 0; j-- ){
            if (arr[j] < arr[j-1]){
                [arr[j],arr[j-1]] = [arr[j-1],arr[j]];
            } 
            else {
                break;
            }
        }
    }
    return arr;
}

console.log(insertionSort([3,2,5,4,1]));


// Another way of doing it.

Array.prototype.iSort = function(){
    for (let i = 0;i<this.length;i++){ // start
        for (let j = i; i > 0; j-- ){
            if (this[j] < this[j-1]){
                [this[j],this[j-1]] = [this[j-1],this[j]];
            } 
            else {
                break;
            }
        }
    }
    return this;
};

const arr = [1,3, 0, 4,6];
console.log(arr.iSort());
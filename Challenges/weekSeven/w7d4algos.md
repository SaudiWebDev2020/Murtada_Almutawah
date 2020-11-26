# November 25th Algorithms

## Partition Array

Using JavaScript, create a function that takes an array and partitions it, moves values less than the partition value to its left and more than it to its right. We will assume there are no duplicates. We can also pick the value at index `0` as the partition value. And lastly we want to return the new index where the partition value ends up.

```js
function partition(arr) {
    let partitionIndex = 0;
    let partitionValue = arr[0];
    // your code here
    return partitionIndex;
}

console.log(partition([2,4,1,0,5,7,3]);
// this should rearrange the array to something like [1, 0, 2, 4, 5, 7, 3] and return the new index of 2
```

<hr>

## Quick Sort

Using JavaScript, create a function that uses quick sort to sort an array in place. We may need to modify our `partition` function to make it accept a start and end index.

<img src="https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif" alt="example"  />

```js
function quickSort(arr) {
    // your code here
    return arr;
}

console.log(quickSort([3,2,5,4,1]));
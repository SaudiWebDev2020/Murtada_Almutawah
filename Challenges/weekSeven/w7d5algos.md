# November 26th Algorithms

## Radix Sort

Write a function called `radixSort` that takes an array and sorts it by starting at the digits in the 1s place and putting each element into a corresponding "bucket" 0-9.

```js
// example array [12, 9, 20, 15, 121, 3]
// looking at the 1s place
let buckets = [ [20], [121], [12], [3], [], [15], [], [], [], [9] ];
// the array then becomes [20, 121, 12, 3, 15, 9]
```

We then continue for the 10 place digit

```js
// example array [121, 20, 12, 3, 15, 9]
// looking at the 10s place
let buckets = [ [3, 9], [12, 15], [121, 20], [], [], [], [], [], [], [] ];
// the array then becomes [3, 9, 12, 15, 121, 20]
```

And for the 100s digit

```js
// example array [3, 9, 12, 15, 121, 20]
// looking at the 100s place
let buckets = [ [3, 9, 12, 15, 20], [121], [], [], [], [], [], [], [], [] ];
// the array then becomes [3, 9, 12, 15, 20, 121]
```

And continue this process until we reach the highest power of 10 present
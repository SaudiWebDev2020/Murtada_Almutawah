// 1. Get 1 to 255 - Write a function that returns an array with all the numbers from 1 to 255.

function get1to255() {
    var arr = [];
    for (var i = 1; i <= 255; i++){
        arr.push(i);
    }
    return arr;
}

//console.log(get1to255());

// 2. Get even 1000 - Write a function that would get the sum of all the even numbers from 1 to 1000.  You may use a modulus operator for this exercise.

function getEven1000() {
    var sum = 0;
    for (var i = 1; i <= 1000; i++){
        if (i % 2 == 0) {
            sum += i;
        }
        
    }
    return sum;
}

//console.log(getEven1000());


// 3. Sum odd 5000 - Write a function that returns the sum of all the odd numbers from 1 to 5000. (e.g. 1+3+5+...+4997+4999).

function sumOdd5000() {
    var sum = 0;
    for (var i = 1; i <= 5; i++){
        if (i % 2 == 1) {
            sum += i;
        }
        
    }
    return sum;
}

// console.log(sumOdd5000());


// 4. Iterate an array - Write a function that returns the sum of all the values within an array. (e.g. [1,2,5] returns 8. [-5,2,5,12] returns 14).

function sumOfArr(arr) {
    var sum = 0;
    for (var i = 0; i < arr.length; i++){
            sum += arr[i];        
    }
    return sum;
}

// console.log(sumOfArr([1, 2, 5]));
// console.log(sumOfArr([-5,2,5,12]));

// 5. Find max - Given an array with multiple values, write a function that returns the maximum number in the array. (e.g. for [-3,3,5,7] max is 7)

function findMax(arr) {
    var max = arr[0];
    for (var i = 1; i < arr.length; i++){
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

// console.log(findMax([-3,3,5,7]));

// 6. Find average - Given an array with multiple values, write a function that returns the average of the values in the array. (e.g. for [1,3,5,7,20] average is 7.2)

function findAverage(arr) {
    var sum = 0;
    for (var i = 0; i < arr.length; i++){
            sum += arr[i];
    }
    return sum/arr.length;
}

// console.log(findAverage([1,3,5,7,20]));

// 7. Array odd - Write a function that would return an array of all the odd numbers between 1 to 50. (ex. [1,3,5, .... , 47,49]). Hint: Use 'push' method.

function arrOdd() {
    var arr = [];
    for (var i = 0; i <= 50; i++){
        if (i % 2 == 1) {
            arr.push(i);
            }
    }
    return arr;
}

// console.log(arrOdd(50));


// 8. Greater than Y - Given value of Y, write a function that takes an array and returns the number of values that are greater than Y. For example if arr = [1, 3, 5, 7] and Y = 3, your function will return 2. (There are two values in the array greater than 3, which are 5, 7).

function graterThanY(arr, y) {
    var grater = [];
    for (var i = 0; i <= arr.length; i++){
        if (arr[i] > y) {
            grater.push(arr[i]);
        }
    }
    return grater;
}

// console.log(graterThanY([1, 3, 5, 7], 3));


// 9.Squares - Given an array with multiple values, write a function that replaces each value in the array with the value squared by itself. (e.g. [1,5,10,-2] will become [1,25,100,4])

function squares(arr) {
    for (var i = 0; i < arr.length; i++){
        arr[i] = arr[i]*arr[i];
    }
    return arr;
}

// console.log(squares([1,5,10,-2]));



// 10. Negatives - Given an array with multiple values, write a function that replaces any negative numbers within the array with the value of 0. When the program is done the array should contain no negative values. (e.g. [1,5,10,-2] will become [1,5,10,0])

function negatives(arr) {
    for (var i = 0; i < arr.length; i++){
        if (arr[i] < 0) {
        arr[i] = 0;
        }
    }
    return arr;
}

// console.log(negatives([1,5,10,-2]));



// 11. Max/Min/Avg - Given an array with multiple values, write a function that returns a new array that only contains the maximum, minimum, and average values of the original array. (e.g. [1,5,10,-2] will return [10,-2,3.5])

function maxMinAvg(arr) {
    var min = arr[0];
    var max = arr[0];
    var sum = 0;

    for (var i = 0; i < arr.length; i++){
        if (max < arr[i]) {
            max = arr[i];
        } else if (min > arr[i]) {
            min = arr[i];
        }
        sum += arr[i];
    }

    var newArr = [max, min, sum / arr.length];

    return newArr;
}

// console.log(maxMinAvg([1, 5, 10, -2]));

// Swap Values - Write a function that will swap the first and last values of any given array. The default minimum length of the array is 2. (e.g. [1,5,10,-2] will become [-2,5,10,1]).

function swapValues(arr) {
    var temp = arr[0];
    arr[0] = arr[arr.length - 1]; // Last to first 
    arr[arr.length - 1] = temp; // first to last 
    return arr;
}

// console.log(swapValues([1, 5, 10, -2]));

// Number to String - Write a function that takes an array of numbers and replaces any negative values within the array with the string 'Dojo'. For example if array = [-1,-3,2], your function will return ['Dojo','Dojo',2].
function numberOfString(arr) {
    for (var i = 0; i < arr.length; i++){
        if (arr[i] < 0) {
        arr[i] = 'Dojo';
        }
    }
    return arr;
}

// console.log(numberOfString([-1, -3, 2]));
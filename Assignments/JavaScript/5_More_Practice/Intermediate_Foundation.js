// 1. Sigma - Implement function sigma(num) that, given a number, returns the sum of all positive integers up to the given number (inclusive).  Ex: sigma(3) = 6 (or 1+2+3); sigma(5) = 15 (or 1+2+3+4+5).

function sigma(num) {
    var sum = 0;
    for (var i = 1; i <= num; i++) {
        sum += i; 
    }
    return sum;
}

// console.log(sigma(3));
// console.log(sigma(5));

// 2. Factorial - Write a function factorial(num) that, given a number, returns the product (multiplication) of all positive integers from 1 up to the given number (inclusive).  For example, factorial(3) = 6 (or 1*2*3); factorial(5) = 120 (or 1*2*3*4*5).

function factorial(num) {
    var mult = 1;
    for (var i = 1; i <= num; i++) {
        mult *= i; 
    }
    return mult;
}

// console.log(factorial(3));
// console.log(factorial(5));


// 3. Fibonacci - Create a function to generate Fibonacci numbers.In this famous mathematical sequence, each number is the sum of the previous two, starting with values 0 and 1.  Your function should accept one argument, an index into the sequence(where 0 corresponds to the initial value, 4 corresponds to the value four later, etc).Examples: fibonacci(0) = 0(given), fibonacci(1) = 1(given), fibonacci(2) = 1(fib(0) + fib(1), or 0 + 1), fibonacci(3) = 2(fib(1) + fib(2)3, or 1 + 1), fibonacci(4) = 3(1 + 2), fibonacci(5) = 5(2 + 3), fibonacci(6) = 8(3 + 5), fibonacci(7) = 13(5 + 8).Do this without using recursion first.If you don't know what a recursion is yet, don't worry as we'll be introducing this concept in Part 2 of this assignment.

function fibonacci(num){
    var sum = 0;
    if (num == 0) {
        return 0;
    }
    if (num == 1) {
        return 1;
    }
    x = 0;
    y = 1;
    for (i = 2; i <= num; i++){
        sum = x + y;
        x = y; 
        y = sum;
    }
    return sum;
}
// console.log(fibonacci(0)); // "0"
// console.log(fibonacci(1)); // "1"
// console.log(fibonacci(2)); // "1"
// console.log(fibonacci(3)); // "2"
// console.log(fibonacci(4)); // "3"
// console.log(fibonacci(5)); // "5"
// console.log(fibonacci(6)); // "8"
// console.log(fibonacci(7)); // "13"
// console.log(fibonacci(20)); // "6765"


// 4. Array: Second - to - Last: Return the second - to - last element of an array.Given[42, true, 4, "Liam", 7], return "Liam".If array is too short, return null.

function secondToLast(arr) {
    if (arr.length > 1) {
        return arr[arr.length - 2];
    } else {
        return null;
    }
}

// console.log(secondToLast([42, true, 4, "Liam", 7]));
// console.log(secondToLast([42]));

// 5. Array: Nth - to - Last: Return the element that is N - from - array's-end.  Given ([5,2,3,6,4,9,7],3), return 4.  If the array is too short, return null.

function nthToLast(arr,n) {
    if (arr.length > n-1) {
        return arr[arr.length - n];
    } else {
        return null;
    }
}

// console.log(nthToLast([5,2,3,6,4,9,7],3));
// console.log(nthToLast([42]));

// 6. Array: Second - Largest: Return the second - largest element of an array.Given[42, 1, 4, 3.14, 7], return 7.  If the array is too short, return null.

function secondLargest(arr) {
    if (arr.length > 1) {
        arr.sort(function(a,b){return a-b});
        return arr[arr.length - 2];
    } else {
        return null;
    }
}

// testArray = [42, 1, 4, 3.14, 7]
// console.log(secondLargest(testArray),testArray);
// console.log(secondLargest([42]));

// 7. Double Trouble: Create a function that changes a given array to list each existing element twice, retaining original order.Convert[4, "Ulysses", 42, false] to[4, 4, "Ulysses", "Ulysses", 42, 42, false, false].

function doubleTrouble(arr) {
    for (var i = arr.length; i > 0; i--){
        last = i * 2;
        arr[last - 1] = arr[i - 1];
        arr[last - 2] = arr[i - 1];
    }

    return arr;
}

// testArray = [4, "Ulysses", 42, false] 
// console.log(doubleTrouble(testArray));
// console.log(testArray);
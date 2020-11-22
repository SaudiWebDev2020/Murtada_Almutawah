/*

*/

Number.prototype.isPrime = function() {
    for( let i=2; i<=Math.sqrt(this); i++ ) { // make it Math.sqrt(this) insted of this made it faster. 
        if( this % i === 0 ) {
            return false;
        }
    }
    return true;
}
const { performance } = require('perf_hooks');
const start = performance.now();
let primeCount = 0;
let num = 2; // for math reasons, 1 is considered prime
while( primeCount < 1e4 ) {
    if( num.isPrime() ) {
        primeCount++;
    }
    num++;
}
console.log(`The 10,000th prime number is ${num-1}`);
console.log(`This took ${performance.now() - start} milliseconds to run`);


// const start11 = performance.now();
// let primeCount1 = 0;
// let num1 = 2; // for math reasons, 1 is considered prime
// while( primeCount1 < 1e6 ) {
//    if( num.isPrime() ) {
//         primeCount1++;
//     }
//     num1++;
// }
// console.log(`The 1,000,000th prime number is ${num1-1}`);
// console.log(`This took ${performance.now() - start11} milliseconds to run`);

// Before adjustment
// The 10,000th prime number is 104729
// This took 169428.7127059996 milliseconds to run

// After adjustment

// The 10,000th prime number is 104729
// This took 1327.3234470039606 milliseconds to run

// The 100,000th prime number is 1299709
// This took 20705.57561700046 milliseconds to run

// The 1,000,000th prime number is 15485863
// This took 1085029.2752379999 milliseconds to run

// ---------------------------------------------

// recursive
const { performance } = require('perf_hooks');
const start2 = performance.now();
function rFib( n ) {
    if ( n < 2 ) {
        return n;
    }
    return rFib( n-1 ) + rFib( n-2 );
}
// console.log('The 50th fib:', rFib(50));
// console.log(`This took ${performance.now() - start2} milliseconds to run in recursive`);

// The 50th fib:  12586269025
// This took 281866.7900179997 milliseconds to run in recursive


// iterative
const start3 = performance.now();
function iFib( n ) {
    const vals = [ 0, 1 ];
    while(vals.length-1 < n) {
        let len = vals.length;
        vals.push( vals[len-1] + vals[len-2] );
    }
    return vals[n];
}

console.log('The 50th fib:', iFib(50));
console.log('The 200th fib:', iFib(200));
console.log(`This took ${performance.now() - start3} milliseconds to run in iterative`);

// iterative is faster.. 
// 
// The 50th fib: 12586269025
// The 200th fib: 2.8057117299251016e+41
// This took 16.569733001291752 milliseconds to run in iterative



const story = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident culpa nihil repellat nulla laboriosam maxime, quia aliquam ipsam reprehenderit delectus reiciendis molestias assumenda aut fugit tempore laudantium tempora aspernatur? Repellendus consequatur expedita doloribus soluta cupiditate quae fugit! Aliquid, repellat animi, illum molestias maiores, laboriosam vero impedit iusto mollitia optio labore asperiores!";

const reversed1 = story.split("").reverse().join("");
console.log(reversed1)

const reverse = (string) => {
    let returned = ""
    for(let i = string.length - 1; i>=0; i--){
        returned += string[i];
    }
    return returned;
};

console.log(reverse(story))


// Problem 1
const cars = ['Tesla', 'Mercedes', 'Honda']
const [ randomCar ] = cars
const [ ,otherRandomCar ] = cars
//Predict the output
console.log(randomCar)          // log Tesla
console.log(otherRandomCar)     // log Mercedes

// Problem 2
const employee = {
    name: 'Elon',
    age: 47,
    company: 'Tesla'
}
const { name: otherName } = employee;
//Predict the output
console.log(name);                      // run time error no initialization for name.
console.log(otherName);                 // log Elon

// Problem 3
const person = {
    name: 'Phil Smith',
    age: 47,
    height: '6 feet'
}
const password = '12345';
const { password: hashedPassword } = person;  
//Predict the output
console.log(password);                          // log 12345
console.log(hashedPassword);                    // log undefined

// Problem 4
const numbers = [8, 2, 3, 5, 6, 1, 67, 12, 2];
const [,first] = numbers;
const [,,,second] = numbers;
const [,,,,,,,,third] = numbers;
//Predict the output
console.log(first == second);                   // "2 == 5" false 
console.log(first == third);                    // "2 == 2" true 

// Problem 5
const lastTest = {
    key: 'value',
    secondKey: [1, 5, 1, 8, 3, 3]
}
const { key } = lastTest;
const { secondKey } = lastTest;
const [ ,willThisWork] = secondKey;
//Predict the output
console.log(key);                       //  log value
console.log(secondKey);                 //  log [1,5,1,8,3,3]
console.log(secondKey[0]);              //  log 1
console.log(willThisWork);              //  log 5

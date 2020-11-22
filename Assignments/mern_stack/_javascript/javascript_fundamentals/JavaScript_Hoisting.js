// GIVEN
// console.log(example);
// var example = "I'm the example!";
// AFTER HOISTING BY THE INTERPRETER
// var example;
// console.log(example); // logs undefined
// example = "I'm the example!";

// 0 
// console.log(example);
// let example = "I'm the example!"; // Give run time error 

// 1 
// console.log(hello);
// var hello = 'world';
// ---------------------------------------------------
// AFTER HOISTING BY THE INTERPRETER
// var hello;
// console.log(hello); // log undefined
// hello = 'world';

// 2 
// var needle = 'haystack'; 
// test();
// function test(){
//     var needle = 'magnet';
//     console.log(needle);
// }
// ---------------------------------------------------
// var needle = 'haystack'; 
// test();
// function test(){
//     var needle = 'magnet'; // overwrite haystack
//     console.log(needle); // lgo magnet
// }

// 3
// var brendan = 'super cool';
// function print(){
//     brendan = 'only okay';
//     console.log(brendan);
// }
// console.log(brendan);
// ---------------------------------------------------
//                                 // var brendan
// var brendan = 'super cool';     // brendan = super cool
// function print(){               
//                                 // var brendan = only okay function scope
//     brendan = 'only okay';      // brendan = only okay
//     console.log(brendan);       
// }
// console.log(brendan);           // log super cool // since no update is called.


// 4 
// var food = 'chicken';
// console.log(food);
// eat();
// function eat(){
//     food = 'half-chicken';
//     console.log(food);
//     var food = 'gone';
// }
// ---------------------------------------------------
//                             // var food
// var food = 'chicken';       // food = chicken
// console.log(food);          // log chicken
// eat();                      // call eat
// function eat(){
//                             // var food
//     food = 'half-chicken';  // food = half-chicken
//     console.log(food);      // log half-chicken
//     var food = 'gone';      // food = gone
// }

// 5 
// mean();
// console.log(food);
// var mean = function() {
//     food = "chicken";
//     console.log(food);
//     var food = "fish";
//     console.log(food);
// };
// console.log(food);
// ---------------------------------------------------
// mean();                     // run time error since 
// console.log(food);
// var mean = function() {
//     food = "chicken";
//     console.log(food);
//     var food = "fish";
//     console.log(food);
// };
// console.log(food);


// 6 
// console.log(genre);
// var genre = "disco";
// rewind();
// function rewind() {
//     genre = "rock";
//     console.log(genre);
//     var genre = "r&b";
//     console.log(genre);
// }
// console.log(genre);
// ---------------------------------------------------
//                             // var genre
// console.log(genre);         // log undefined
// var genre = "disco";        // genre = disco
// rewind();                   // call rewind
// function rewind() {
//                             // var genre
//     genre = "rock";         // genre = rock
//     console.log(genre);     // log rock
//     var genre = "r&b";      // genre = r&b
//     console.log(genre);     // log r&b
// }
// console.log(genre);         // log disco


// 7 
// dojo = "san jose";
// console.log(dojo);
// learn();
// function learn() {
//     dojo = "seattle";
//     console.log(dojo);
//     var dojo = "burbank";
//     console.log(dojo);
// }
// console.log(dojo);
// ---------------------------------------------------
//                             // var dojo
// function learn() {
//                             // var dojo
//     dojo = "seattle";       // dojo = seattle
//     console.log(dojo);      // log seattle
//     var dojo = "burbank";   // dojo = burbank
//     console.log(dojo);      // log burbank
// }
// dojo = "san jose";          // dojo = san jose
// console.log(dojo);          // log san jose
// learn();                    // cal learn
// console.log(dojo);          // log san jose

// 8
// console.log(makeDojo("Chicago", 65));
// console.log(makeDojo("Berkeley", 0));
// function makeDojo(name, students){
//     const dojo = {};
//     dojo.name = name;
//     dojo.students = students;
//     if(dojo.students > 50){
//         dojo.hiring = true;
//     }
//     else if(dojo.students <= 0){
//         dojo = "closed for now";
//     }
//     return dojo;
// }
// ---------------------------------------------------
// function makeDojo(name, students){          
//     const dojo = {};                        // const dojo
//     dojo.name = name;                       // dojo.name = name
//     dojo.students = students;               // dojo.sutdents = students
//     if(dojo.students > 50){                 
//         dojo.hiring = true;                 // dojo.hiring = true
//     }
//     else if(dojo.students <= 0){
//         dojo = "closed for now";            // unexpected error const != re assigning
//     }
//     return dojo;
// }
// console.log(makeDojo("Chicago", 65));       // call makeDojo Chicago, 65 then log {name: Chicago, students: 65, hiring: true}
// console.log(makeDojo("Berkeley", 0));       // call makeDojo berkeley, 0 then run time error un expected error const != re assigning
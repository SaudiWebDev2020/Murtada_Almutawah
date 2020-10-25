// Arrs2Map
// ----------------------------------------------------------------------------------------------------------------
// Given two arrays, create an associative array (map) containing keys of the first, and values of the
// second. For arr1 = ["abc", 3, "yo"] and arr2 = [42, "wassup", true], return {"abc":
// 42, 3: "wassup", "yo": true}.

function arrs2Map(arr1, arr2) {
    console.log(arr1, arr2);
    var obj = {};
    for (var i = 0; i < arr1.length || i < arr2.length; i++){
        obj[arr1[i]] = arr2[i];
    }
    console.log(obj);
    return obj;
}

// DONE Ask about the length => Depending on the needs.
// for the first one we will not have any problem
// for the second one we will have one undifind key for all. 

var testArr1 = ["abc", 3, "yo"];
var testArr2 = [42, "wassup", true, 1, 2]; 
console.log(arrs2Map(testArr1, testArr2));


// InvertHash
// ----------------------------------------------------------------------------------------------------------------
// Create invertHash(assocArr) that converts a hash’s keys to values and values to corresponding keys.
// Example: given {"name": "Zaphod"; "numHeads": 2}, return {"Zaphod": "name"; 2:
// "numHeads"}. You will need to learn and use a JavaScript for ... in h ere!

// Clerifing Qustion ! do you want me to return the same object or return another solution. 

function invertHash(obj) {
    for (var item in obj) {
        temp = item; 
        item = obj[temp];
        obj[item] = temp;
        delete obj[obj[item]];
        // console.log(item, obj[item]);
    }
    return obj;
}

// Another solution

function invertHash2(obj) {
    var newObj = {};
    for (var item in obj) {
        newObj[obj[item]] = item;
    }
    return newObj;
}

testObj = { "name": "Zaphod", "numHeads": 2 };
console.log(testObj);
console.log(invertHash(testObj));
console.log(invertHash2(testObj));


// ReverseString
// ----------------------------------------------------------------------------------------------------------------
// Implement a function reverseString(str) that, given a string, will return the string of the same length but
// with characters reversed. Example: given "creature", return "erutaerc". Do not use the built-in
// reverse() function!

function reverseString(str) {
    newStr = "";
    for (var i = str.length - 1; i >= 0; i--){
        newStr += str[i];
        //console.log(str[i],newStr);   
    }
    return newStr;
}

// Another solution in forword way 
function reverseString2(str) {
    newStr = "";
    for (var i = 0; i < str.length; i++){
        newStr = str[i]+ newStr;
        //console.log(str[i],newStr);   
    }
    return newStr;
}

var testStr = 'creature';
console.log(testStr);
console.log(reverseString(testStr));
console.log(reverseString2(testStr));
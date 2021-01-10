function encode(str) {
  let newStr = "";
  // your code here

  if (str) {
		// init
    let prevChar = str[0];
		let count = 1;
		
    // looping
    for (let i = 1; i < str.length; i++) {
      if (str[i] === prevChar) {
        count++;
      } else {
        newStr += `${prevChar}${count}`;
        prevChar = str[i];
        count = 1;
      }
    }

    // last one
    newStr += `${prevChar}${count}`;
  }

  return newStr;
}

console.log(encode("aaabccdddd"));
console.log(encode(""));
// should return "a3b1c2d4"

function decode(str) {
	// Solution has a problem if the number is 2 or more digit. 
	
  let newStr = "";
  // your code here

  // loop to decode
  for (let i = 0; i < str.length; i = i + 2) {
    let char = str[i];
    let count = str[i + 1];

    newStr += char.repeat(count);
  }
  return newStr;
}

console.log(decode("a3b1c2d4"));
console.log(decode(""));
// should return "aaabccdddd"



// console.log(decode(encode("tttest")));

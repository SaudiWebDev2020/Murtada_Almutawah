function dec2bin(num, largest) {
  let res = "";

  // console.log(num);
  let power = Math.floor(Math.log(num) / Math.log(2));

  while (power > 0) {
    let val = Math.floor(num / Math.pow(2, power));
    res += val;
    num %= Math.pow(2, power);
    power--;
  }

  res += num;

  while (res.length < largest) {
    res = 0 + res;
  }

  return res;
}

function bin2dec(str) {
  let res = 0;
  // your code here
  count = 0;
  for (let i = str.length - 1; i >= 0; i--) {
    let power = 2 ** count;
    if (str[i] == 1) {
      res += power;
    } else if (str[i] == "b") {
      break;
    }
    count++;
  }
  return res;
}

function radix2(arr) {
  let temp = [];
  let zeros = [];
  let ones = [];
  let power = 0;

  // DONE - find the largest value in the arr
  let largest = arr[0];
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] > largest) {
      largest = arr[i];
    }
  }

  // determine how many times we need to loop
  power = Math.floor(Math.log(largest) / Math.log(2));

  // Convert the list to binary
  for (let i = 0; i < arr.length; i++) {
    temp.push(dec2bin(arr[i], power + 1));
  }

  // Compare
  while (power >= 0) {
    // put the values where 2**power when & with each number give 0 into the zeros
    // and the other into the ones
    // keep going until everything is sorted
    for (let i = 0; i < temp.length; i++) {
      if (temp[i][power] == 1) {
        ones.push(temp[i]);
      } else {
        zeros.push(temp[i]);
      }
    }

    let numZeros = zeros.length - 1;
    let numOnes = ones.length + numZeros;

    while (ones.length > 0) {
      temp[numOnes] = ones.pop();
      numOnes--;
    }

    while (zeros.length > 0) {
      temp[numZeros] = zeros.pop();
      numZeros--;
    }

    power--;
  }

  for (let i = 0; i < temp.length; i++) {
    temp[i] = bin2dec(temp[i]);
  }

  return temp;
}
const values = [13, 14, 15, 2, 3, 9, 6, 100, 4096];
// 0b1101, 0b1110, 0b1111, 0b0010, 0b0011, 0b1001, 0b0110
console.log(radix2(values));
// we should expect back [2, 3, 6, 9, 13, 14, 15]

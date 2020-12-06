function intersect(arr1, arr2) {
  let newArr = [];
  let obj1 = {};
  let obj2 = {};

  for (let i = 0; i < arr1.length; i++) {
    if (obj1[arr1[i]]) {
      obj1[arr1[i]] += 1;
    } else {
      obj1[arr1[i]] = 1;
    }
  }

  for (let i = 0; i < arr2.length; i++) {
    if (obj2[arr2[i]]) {
      obj2[arr2[i]] += 1;
    } else {
      obj2[arr2[i]] = 1;
    }
  }

  for (let key in obj1) {
    let iter = 0;
    if (obj1[key] < obj2[key]) {
      iter = obj1[key];
    } else {
      iter = obj2[key];
    }
    for (let i = 0; i < iter; i++) {
      newArr.push(key);
    }
  }

  //   console.log(obj1, obj2);
  return newArr;
}

console.log(intersect([1, 2, 2, 2, 7], [2, 2, 6, 6, 7]));
// this should return [2, 2, 7]

function union(arr1, arr2) {
  let newArr = [];
  let obj1 = {};
  let obj2 = {};
  let allObj = {};

  for (let i = 0; i < arr1.length; i++) {
    if (obj1[arr1[i]]) {
      obj1[arr1[i]] += 1;
    } else {
      obj1[arr1[i]] = 1;
      allObj[arr1[i]] = 1;
    }
  }

  for (let i = 0; i < arr2.length; i++) {
    if (obj2[arr2[i]]) {
      obj2[arr2[i]] += 1;
    } else {
      obj2[arr2[i]] = 1;
      allObj[arr2[i]] = 1;
    }
  }

  for (let key in allObj) {
    let iter = 0;
    if (obj1[key] === undefined) {
      iter = obj2[key];
    } else if (obj2[key] === undefined) {
      iter = obj1[key];
    } else {
      if (obj1[key] > obj2[key]) {
        iter = obj1[key];
      } else {
        iter = obj2[key];
      }
    }
    // console.log(key, iter);

    for (let i = 0; i < iter; i++) {
      newArr.push(key);
    }
  }

  //   console.log(obj1, obj2);
  //   console.log(allObj);
  return newArr;
}

console.log(union([1, 2, 2, 2, 7], [2, 2, 6, 6, 7]));
// this should return [1, 2, 2, 2, 6, 6, 7]

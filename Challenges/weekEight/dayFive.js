function allCombinations(words) {
  const combinations = [];
  // your code here
  function helper(listWord, str) {
    if (listWord.length == 0) {
      // console.log(str);
      combinations.push(str.trim());
    } else {
      let list = listWord[0];
      let [, ...remaining_list] = listWord;
      for (let i = 0; i < list.length; i++) {
        helper(remaining_list, str + " " + list[i]);
      }
    }
  }
  helper(words, "");

  return combinations;
}

function rallCombinations(words, str = "", saved_list = []) {
  if (words.length == 0) {
    // console.log(str);
    saved_list.push(str.trim());
  } else {
    let list = words[0];
    let [, ...remaining_list] = words;
    for (let i = 0; i < list.length; i++) {
      rallCombinations(remaining_list, str + " " + list[i], saved_list);
    }
  }

  return saved_list;
}

const words = [
  ["quick", "lazy"],
  ["brown", "red", "grey"],
  ["fox", "dog"],
];

console.log(rallCombinations(words));
// should return ["quick brown fox", "quick brown dog", "quick red fox", "quick red dog", "quick grey fox", "quick grey dog", "lazy brown fox", "lazy brown dog", "lazy red fox", "lazy red dog", "lazy grey fox", "lazy grey dog"]
// Hint you may need to consider recursion

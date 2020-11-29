function strToWordArr(str) {
    const words = [];
    // your code here
    let word = ""
    for(let i = 0;i<str.length;i++){
        if(str[i]==' '){
            // console.log(word)
            words.push(word);
            word = '';
        } else {
            word = word + str[i];
        }
    }
    words.push(word)
    return words;
}

console.log(strToWordArr("Hello world and good morning!"));
// should return ["Hello", "world", "and", "good", "morining!"]


function reverseWords(str) {
    let reversed = "";
    // your code here
    words = strToWordArr(str);
    for (let x=words.length-1;x>=0;x--){
        reversed = reversed + `${words[x]} `;
    }
    return reversed;
}

console.log(reverseWords("Hello world and good morning!"));
// should return "morning! good and world Hello";
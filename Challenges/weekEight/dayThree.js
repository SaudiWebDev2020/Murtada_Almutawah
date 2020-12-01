function dedupe(str) {
    let newStr = "";
    // your code here
    for(let i = 0; i<str.length;i++){
        let dup = true;
        for(let x = 0;x<newStr.length;x++){
            if(str[i]===newStr[x]){
                dup = false
                break;
            }
        }
        if(dup){
            newStr = newStr + str[i];
        }
    }
    return newStr;
}

function dedupe2(str) {
    let newStr = "";
    // your code here
    let letters = {};
    for(let i = 0; i<str.length;i++){
       if(!letters[str[i]]){
        newStr += str[i];
        letters[str[i]] = i;
        }
    }
    return newStr;
}

console.log(dedupe("Snap, crackle and pop!"));
// should return something like "Snap, crkledo!"
console.log(dedupe2("hello world"));
// should return something like "helo wrd"
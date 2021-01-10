function rotate(str, num) {
    let newStr = "";
    // your code here
    index = str.length - num;
    while (newStr.length !== str.length){
        if (index < str.length){
            newStr += str[index];
            index++;
        }
        else{
            index = 0;
        }
    }
    return newStr;
}


console.log( rotate("Boris Godunov", 3) );
  // should return "novBoris Godu"



function isRotation(str1, str2) {
    // Solution problem. 
    //   - if we have 2 characters similar to the first character. (which one will be chosen ?)
    let theyMatch = true;
    // your code here
    if(str1.length !== str2.length){
        return false;
    } else{
        var str2Index = str2.indexOf(str1[0]);
        // console.log(str2Index);
        let index = 0;
        while (index < str1.length){
            // console.log(index,str1.length);           
            if (str1[index] !== str2[str2Index]){
                return false;
            } else{
                str2Index++;
                index++;
                if (str2Index >= str2.length){
                    str2Index = 0;
                }
            }
        }
    }
    return theyMatch;
}

console.log( isRotation("Bingo", "goBin") );
// should return true.

console.log( isRotation("Bingo", "ogniB") );
// should return false.

console.log( isRotation("BinBo", "BoBin") );
// should be true =).
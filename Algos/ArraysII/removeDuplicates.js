function removeDuplicates(arr) {
    // [1,4,2,1,4,6,7] => [1,4,2,6,7]

    let testArr = [];
    // loop through arr
    for(let i = 0; i < arr.length; i++) {
        // check to see if testArr contains arr[i]?
        if(testArr.indexOf(arr[i]) === -1)
            testArr.push(arr[i]);
    }
    return testArr;

}

let testArr = [1,4,2,1,4,6,7];
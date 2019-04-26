function removeDuplicatesOne(arr) {
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


function removeDuplicatesTwo(arr) {
    /*
    testArr = []
    count = 0
    loop array (i start of array to array.length - count)
        if arr[i] is in testArr:
            shift values ahead of arr[i] to the left (if not last)
            count++
    arr.length = arr.length - count
    */
    let testArr = [];
    let valCount = {};
    let numDupesEncountered = 0;
    for(let i = 0; i < arr.length - numDupesEncountered; i++) {
        // { 1: true, 3: true}
        // if(valCount[arr[i]])
        if(testArr.indexOf(arr[i]) !== -1) {
            numDupesEncountered++;
            // shift values ahead of arr[i] to the left (if not last)
            for(let k = i; k < arr.length - numDupesEncountered; k++) {
                if(k != arr.length - 1) {
                    arr[k] = arr[k + 1];
                }
            }
            i--;
            
            
        } else {
            testArr.push(arr[i]);
        }
        // valCount[arr[i]] = true;
    }
    arr.length = arr.length - numDupesEncountered;
}

let testArr = [1,4,2,1,4,6,7];
console.log(testArr);
// (Warm-up) Always run through some quick algorithm problems before any coding interview, to get yourself warmed up. 
// How about this one: return the average value of an array of unsorted numbers . 

function averageArrayValues(array) {
    let sum = 0;
    const count = array.length;

    if(count === 0)
        return "ZERO THINGS";

    // initia
    for(let i = 0; i < count; i++) {
        sum += array[i];
    }
    return sum/count;
}


//  Write a function that returns whether the given array has a balance point between indices, 
// where one side’s sum is equal to the other’s. 
//Example: [1,2,3,4,10] → true ( between indices 3&4 ), but [1,2,4,2,1] → false . 

function balancePoint(arr) {
    let sum1 = 0,
    sum2 = 0;
    
    for(let i = 0; i < arr.length; i++) {
        sum1 += arr[i];
        
        // [5,2,3,4]
        //    i k
        
        
        for(let k = i + 1; k < arr.length; k++) {
            sum2 += arr[k];
        }
        
        if(sum1 === sum2)
        return true;
        
        sum2 = 0;
    }
    return false;
}




// Here, a balance point is on an index, not between indices. 
// Return the balance index where sums are equal on either side (exclude its own value). 
// Return -1 if none exist. Ex.: [-2,5,7,0,3] → 2 , but [9,9] → -1 . 

function balanceIndex(arr) {
    let sum1 = 0,
        sum2 = 0;

    if(arr.length === 1)
        return 0;
    
    for(let i = 1; i < arr.length; i++) {
        sum1 += arr[i - 1];
        
        // [5,2,2,3]
        //    i k
        
        
        for(let k = i + 1; k < arr.length; k++) {
            sum2 += arr[k];
        }
        
        if(sum1 === sum2)
            return i;
        
        sum2 = 0;
    }
    return -1;
}
const test_1 = [5,2,2,3]; // 1
const test_2 = [2,4,4,2]; // -1
const test_3 = [5,5,4,10]; // 2

console.log(balanceIndex(test_1));
console.log(balanceIndex(test_2));
console.log(balanceIndex([2]));
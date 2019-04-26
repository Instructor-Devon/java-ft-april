function mode(arr) {
    // Create a function that, given an array, 
    // returns the most frequent value in the array. 
    let map = {},
        currMode = -1,
        currMaxTimes = 0;
    
    for(let i=0; i<arr.length; i++) {
        if(!map[arr[i]]) {
            map[arr[i]] = 1;
        } else {
            map[arr[i]]++;
        }
        if(map[arr[i]] > currMaxTimes) {
            currMaxTimes = map[arr[i]];
            currMode = arr[i];
        }
    }
    /*
        find most common value
        store in variable

        [12,1,1,1,5,5,5,2,2,2]
        [1]

        {
            12:1
            1:3,
            5:3,
            2:3
        }
    */
//    // [12,1,5,2]
//     for(let key of Object.keys(map)) {
//         if(map[key] > currMode)
//             currMode = key;
//     }

    return currMode;
    /*
    find the key with the biggest value => 2
    (loop the keys of our map, pull out largest value)
    int max = -1;
    for key in map
    if map[key] > max
    max = key
    
    return max
    */
}
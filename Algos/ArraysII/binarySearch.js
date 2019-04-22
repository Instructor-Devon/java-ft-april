function binarySearch(arr, val, midpoint = Math.ceil(arr.length/2)) {

    // returns true if value found (false if not)

    //  0 1 2 3  4  5
    // [2,4,6,8,10,190]

    if(arr[midpoint] === val)
        return true;
    
    if(midpoint === 0 || midpoint === arr.length - 1)
        return false;

    if(val < arr[midpoint]) {
        // look left, find new midpoint
        let newMid = Math.ceil((midpoint - 0) / 2);
        if(newMid === midpoint)
            newMid--;

        return binarySearch(arr, val, newMid);
    } else {
        // look right, find new midpoint
        let offset = ((arr.length - 1) - midpoint) / 2;
        midpoint = (arr.length - 1) - offset;
        return binarySearch(arr, val, Math.ceil(midpoint));
    }


}
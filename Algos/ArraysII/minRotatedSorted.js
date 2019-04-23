// You will be given a numerical array that has first been sorted, then rotated by an unknown amount. 
// Find and return the minimum value in that array. Don’t use built-in functions (surprise!). Given the input array 
//["Gigli","Jay is cool","Mavis","Phoebe","Thurber","Anna","Celeste","Elon"] , 
// you should return "Anna" . Remember, do not linearly iterate the array! 

//           S       M     E
var array1 = [5,6,7,8,1,2,3,4];

//           S     E
var array2 = [8,1,2,3,4,5,6,7];

//                   S   M E
var array3 = [4,5,6,7,8,1,2,3];

function minSortedRotated(arr) {
    var mid = Math.floor(arr.length/2);
    var start = 0;
    var end = arr.length - 1;

    while(end - start != 1) {
        // check if arr[mid] is larger than arr[mid - 1]
        if(arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }
        if(arr[end] < arr[mid]) {
            start = mid;
        } else {
            end = mid - 1;
        }
        mid = Math.floor((start + end) / 2);
    }

}

function binaryStringSearch(word) {
    for(var w of word) {
        console.log(w.charCodeAt());
    }
}

console.log(minSortedRotated(array1))
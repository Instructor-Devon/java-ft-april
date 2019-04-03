function removeMins(queue) {
    // Create a standalone function to remove an SLQueue ’s lowest value, 
    //otherwise leaving values in the same sequence. 
    //Use only local variables; allocate no other objects. 
    //Remove all duplicates of this value. 

    // todo: go through and find min value DONE
    var min = queue.getMin();
    if(min === null)
        return null;
    var curr = queue.head;
    while(curr.next) {
        if(curr.next.value === min) {
            curr.next = curr.next.next;
        }
        if(!curr.next)
            break;
        curr = curr.next;
    }
}

var testQ = new SLQueue();

testQ.enqueue(1);
testQ.enqueue(12);
testQ.enqueue(-100);
testQ.enqueue(4);
testQ.enqueue(-300);
console.log(testQ.getMin());
removeMins(testQ);
console.log(testQ);

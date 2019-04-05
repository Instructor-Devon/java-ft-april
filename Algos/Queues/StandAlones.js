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



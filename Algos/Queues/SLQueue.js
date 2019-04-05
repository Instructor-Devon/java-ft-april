function SLQueue() {
    this.head = null;
    this.tail = null;

    this.isEmpty = function() {
        // if(this.tail === null)
        //     return true;
        // return false;
        return this.tail === null;
    }

    this.hasOneThing = function() {
        return this.tail === this.head;
    }

    this.enqueue = function(val) {
        var newThing = new SLNode(val);

        if(this.isEmpty()) {
            this.head = newThing;
        } else {
            this.tail.next = newThing;
        }
        this.tail = newThing;
        return newThing;
    }

    this.getMin = function() {
        // if empty return null
        if(this.isEmpty())
            return null;

        var min = this.head.value;
        //  varable assignment ; end condtion ; this happens after each iteration
        for(var curr = this.head; curr != null; curr = curr.next) {
            if(curr.value < min)
                min = curr.value;
        }
        return min;
    }

    this.dequeue = function() {
        // assign the head's next to head
        if(this.isEmpty())
            return "hey no stuff";
        var toReturn = this.head;
        this.head = this.head.next;
        return toReturn.value;
    }

    this.contains = function(valToFind) {
        var current = this.head;
        while(current) {
            if(current.value === valToFind)
                return true;
            current = current.next;
        }
        return false;
    }

    this.size = function() {
        var count = 0,
            current = this.head;
        while(current) {
            count++;
            current = current.next;
        }
        return count;
    }

    //Reorder SLQueue values to alternate first half values with second half values, in order. 
    //For example: (1,2,3) (4,5,6) becomes (1,4,2,5,3,6) . You may create one additional SLQueue , if needed. 
    // (1,2,3)(4,5)   (1,4,2,5,3) 
    //
    this.interleave = function() {
        // find midpoint
        var midpoint = Math.ceil(this.size()/2);
        // find node at "midpoint" and return it
        var count = 0,
            curr = this.head,
            secondHalf = new SLQueue();

            
        // build 2nd queue starting at midpoint
        while(curr) {
            // we are now at the midpoint
            if(count >= midpoint)
                secondHalf.enqueue(curr.value);
            count++;
            curr = curr.next;
        }
        console.log(secondHalf);
        curr = this.head;
        var secCurr = secondHalf.head,
            interleaved = new SLQueue();
        
        // loop both, enqueue starting at each's head
        while(curr) {
            interleaved.enqueue(curr.value);
            if(secCurr)
                interleaved.enqueue(secCurr.value);
            else
                break;

            curr = curr.next;
            secCurr = secCurr.next;
        }
        return interleaved;
    }
}

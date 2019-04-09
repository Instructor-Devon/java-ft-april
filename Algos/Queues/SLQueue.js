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

    this.isEven = function() {
        return this.size() % 2 === 0;
    }

    //Reorder SLQueue values to alternate first half values with second half values, in order. 
    //For example: (1,2,3) (4,5,6) becomes (1,4,2,5,3,6) . You may create one additional SLQueue , if needed. 
    // (1,2,3)(4,5)   (1,4,2,5,3) 
    //
    this.interleave = function() {
        // find midpoint
        // turnary = (bool?) ? if true do this : if false do this
        var midpoint = (this.size() % 2 == 0) 
            ? Math.floor(this.size()/2)
            : Math.floor(this.size()/2) + 1;
        // find node at "midpoint" and return it
        var count = 0,
            curr = this.head,
            secondHalf = new SLQueue();

            
        // build 2nd queue starting at midpoint
        while(curr) {
            // we are now at the midpoint
            // we are getting double 2nd half values (near midpoint)
            if(count >= midpoint)
                secondHalf.enqueue(curr.value);
            count++;
            curr = curr.next;
        }
        console.log(secondHalf);
        curr = this.head;
        var secCurr = secondHalf.head,
            interleaved = new SLQueue();

        while(curr && secCurr) {
            interleaved.enqueue(curr.value);
            interleaved.enqueue(secCurr.value);
           
            curr = curr.next;
            secCurr = secCurr.next;
        }
        if(!this.isEven() && curr)
            interleaved.enqueue(curr.value);
        return interleaved;
    }
}

var test = new SLQueue();
// we want mid: 3
test.enqueue(1);
test.enqueue(2);
test.enqueue(3);
test.enqueue(4);
test.enqueue(5);
// 1, 4, 2, 5, 3

// mid: 3
var test2 = new SLQueue();
test2.enqueue(1);
test2.enqueue(2);
test2.enqueue(3);
test2.enqueue(4); // mid: 3
test2.enqueue(5);
test2.enqueue(6);
// 1, 4, 2, 5, 3, 6
function SLQueue() {
    this.head = null;
    this.tail = null;

    this.isEmpty = function() {
        // if(this.tail === null)
        //     return true;
        // return false;
        return this.tail === null;
    }

    this.enqueue = function(val) {
        var newThing = new SLNode(val);

        if(this.isEmpty()) {
            this.head = newThing;
        } else {
            this.tail.next = newThing;
        }
        this.tail = newThing;
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
}


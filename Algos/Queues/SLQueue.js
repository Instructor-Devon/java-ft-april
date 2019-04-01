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
}

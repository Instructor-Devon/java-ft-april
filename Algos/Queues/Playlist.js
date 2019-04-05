function Playlist () {
    this.queue = new SLQueue();

    // private SLNode currentSong;
    this.currentSong = this.queue.head;
    // Object song 
    this.addSong = function(song) {
        // we want to make the first song added
        // the currentSong
        var newSongNode = this.queue.enqueue(song);
        if(this.queue.hasOneThing())
            this.currentSong = newSongNode;
    }

    this.currentlyPlaying = function(){
        if(this.queue.isEmpty())
            return "No Song Playing";
        
        const {artist, song} = this.currentSong.value;

        return `${artist} - ${song}`;
        // return 
    }

    this.skipTrack = function() {
        if(this.currentSong.next)
            this.currentSong = this.currentSong.next;
    }
}
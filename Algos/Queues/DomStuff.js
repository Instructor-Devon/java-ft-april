var formy = document.getElementById("selector");
var playing = document.getElementById("playing");
var next = document.getElementById("next");
// atatching event listeners
var playlist = new Playlist();

displayCurrentSong(playing);

next.addEventListener("click", () => {
    playlist.skipTrack();
})

formy.addEventListener("submit", (event) => {
    event.preventDefault();
    var artist = event.target[0].value;
    var song = event.target[1].value;
    playlist.addSong({
        artist: artist,
        song: song
    })
    displayCurrentSong(playing)
});

function displayCurrentSong(displayInterface) {
    displayInterface.innerHTML = `Currently Playing: ${playlist.currentlyPlaying()}`;
}
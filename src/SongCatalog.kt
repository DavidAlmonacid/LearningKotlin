//Imagine that you need to create a music-player app.
//
//Create a class that can represent the structure of a song. The Song class must include these code elements:
//
//Properties for the title, artist, year published, and play count
//A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
//A method that prints a song description in this format:
//"[Title], performed by [artist], was released in [year published]."

class SongCatalog(
    private val title: String,
    private val artist: String,
    private val yearPublished: Int,
    private val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1_000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

fun main() {
    val brunoSong = SongCatalog("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
    brunoSong.printDescription()
    println(brunoSong.isPopular)
}

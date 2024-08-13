import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SongCatalogTest {

    @Test
    fun isPopular() {
        val song = SongCatalog("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
        assertTrue(song.isPopular)
    }
}
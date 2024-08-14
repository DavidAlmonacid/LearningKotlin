import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SpecialAuctionKtTest {

    @Test
    fun auctionPrice() {
        val winningBid = Bid(5000, "Private Collector")

        assertEquals(5000, auctionPrice(winningBid, 2000))
        assertEquals(3000, auctionPrice(null, 3000))
    }
}
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FoldablePhoneTest {

    @Test
    fun isFoldableByDefault() {
        val phone = FoldablePhone()
        assertTrue(phone.isFolded)
    }

    @Test
    fun canUnfoldPhone() {
        val phone = FoldablePhone()
        phone.unfold()
        assertFalse(phone.isFolded)
    }

    @Test
    fun canFoldPhone() {
        val phone = FoldablePhone()
        phone.unfold()
        phone.fold()
        assertTrue(phone.isFolded)
    }
}
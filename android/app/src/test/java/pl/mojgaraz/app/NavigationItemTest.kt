package pl.mojgaraz.app

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import pl.mojgaraz.app.domain.model.NavigationItem

class NavigationItemTest {
    @Test
    fun `nawigacja zawiera piec podstawowych sekcji`() {
        assertEquals(5, NavigationItem.entries.size)
        assertEquals(
            listOf("start", "tools", "parts", "inventory", "more"),
            NavigationItem.entries.map { it.route },
        )
    }

    @Test
    fun `kazda sekcja ma etykiete i ikone`() {
        NavigationItem.entries.forEach { item ->
            assertTrue(item.labelRes > 0)
            assertTrue(item.icon.name.isNotEmpty())
        }
    }
}

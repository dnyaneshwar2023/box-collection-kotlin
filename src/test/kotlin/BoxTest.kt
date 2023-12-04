import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BoxTest {

    @Test
    fun `creates a box object`() {
        val box = Box<Any>()

        assertEquals(box::class.java.name, "Box")
    }

    @Test
    fun `it should put the object in the box at particular partition`() {
        val item = 1
        val box = Box<Any>()

        val keptItem = box.put(PartitionType.TOP, item)

        assertEquals(1, keptItem)
    }

    @Test
    fun `it should get item at particular partition`() {
        val box = Box<Any>()

        box.put(PartitionType.TOP, 1)
        box.put(PartitionType.MIDDLE, 2)

        val receivedItem = box.get(PartitionType.MIDDLE)

        assertEquals(2, receivedItem)
    }

    @Test
    fun `it should be able to put item of only one type in the box`() {
        val box = Box<Int>()

        box.put(PartitionType.TOP, 1)

//        box.put("1")
    }

    @Test
    fun `it should be able to sort the partitions based on specific parameters`() {
        class Book(val name: String, val author: String, val numberOfPages: Int)

        val box = Box<Book>()

        box.put(PartitionType.BOTTOM, Book("Wings", "APJ", 100))
        box.put(PartitionType.MIDDLE, Book("TDD", "Bob", 999))
        box.put(PartitionType.TOP, Book("Clean Code", "Uncle", 400))

        box.sortBy { it.numberOfPages }

        val expectedItemAtTop = 100

        val receivedItem = box.get(PartitionType.TOP)

        assertEquals(expectedItemAtTop, receivedItem!!.numberOfPages)
    }
}

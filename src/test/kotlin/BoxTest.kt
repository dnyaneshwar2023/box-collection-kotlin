import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.expect

class BoxTest {

    @Test
    fun `creates a box object`() {
        val box = Box<Any>();

        assertEquals(box::class.java.name, "Box")
    }

    @Test
    fun `it should put the object in the box`() {
        val item = 1;
        val box = Box<Any>()

        val keptItem = box.put(item);

        assertEquals(1, keptItem)
    }

    @Test
    fun `it should get item at particular index`() {
        val box = Box<Any>()

        box.put(1)
        box.put(2)

        val receivedItem = box.get(1);

        assertEquals(2, receivedItem)
    }

    @Test
    fun `it should be able to put item of only one type in the box`() {
        val box = Box<Int>()

        box.put(1)

//        box.put("1")
    }

    @Test
    fun `it should be able to sort the partitions based on specific parameters`() {
        class Car(val value: Int)

        val box = Box<Car>()

        box.put(Car(3))
        box.put(Car(2))
        box.put(Car(1))

        box.sortBy { it.value }

        assertEquals(Car(1).value,box.get(0).value)
    }


}

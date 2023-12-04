import kotlin.reflect.KProperty1

class Box<T> {
    var topPartition: Partition<T> = Partition()
    var middlePartition: Partition<T> = Partition()
    var bottomPartition: Partition<T> = Partition()

    fun put(partition: PartitionType, item: T): T {
        when (partition) {
            PartitionType.TOP -> topPartition.put(item)
            PartitionType.MIDDLE -> middlePartition.put(item)
            PartitionType.BOTTOM -> bottomPartition.put(item)
        }

        return item
    }

    fun get(partition: PartitionType): T? {
        return when (partition) {
            PartitionType.TOP -> topPartition.get()
            PartitionType.MIDDLE -> middlePartition.get()
            PartitionType.BOTTOM -> bottomPartition.get()
        }
    }
}

fun <T, R : Comparable<R>> Box<T>.sortBy(selector: (T) -> R) {

    listOfNotNull(this.topPartition.get(), this.middlePartition.get(), this.bottomPartition.get())
        .sortedWith(compareBy(selector))
        .let { list ->
            this.topPartition.put(list[0])
            this.middlePartition.put(list[1])
            this.bottomPartition.put(list[2])
        }
}

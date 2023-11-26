class Box<T> {
     val items = mutableListOf<T>()

    fun put(item: T): T {
        items.add(item)
        return item
    }

    fun get(partition: Int): T {
        return items[partition]
    }
}

fun<T,R : Comparable<R>> Box<T>.sortBy(selector: (T) -> R) {
    this.items.sortWith(compareBy(selector))
}

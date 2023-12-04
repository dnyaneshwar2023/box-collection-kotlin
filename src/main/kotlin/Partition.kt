class Partition<T> {
    private var item: T? = null

    fun put(item: T) {
        this.item = item
    }

    fun get(): T? {
        return this.item
    }
}

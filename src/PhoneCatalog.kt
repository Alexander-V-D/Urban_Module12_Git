abstract class PhoneCatalog {

    abstract val phoneList: List<String>

    abstract val priceList: List<Int>

    abstract fun getCatalog(): List<Pair<String, Int>>
}
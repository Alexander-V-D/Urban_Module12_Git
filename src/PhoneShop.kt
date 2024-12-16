class PhoneShop(val city: String, override val priceList: List<Int>): PhoneCatalog(), HasIncome {

    override val phoneList: List<String> = listOf(
        "Truephone 17",
        "Sharpstar Pro 14",
        "Owl Pro Max Plus Ultra"
    )

    override fun getCatalog() = phoneList.zip(priceList)

    private val soldPhones = MutableList(getCatalog().size) { 0 }

    fun sellPhone(index: Int) = soldPhones[index - 1]++

    fun getSoldPhones() = soldPhones.toList()

    override fun getIncome(): Int {
        var sum = 0
        for (i in 0..<(getCatalog().size)) {
            sum += getCatalog()[i].second * getSoldPhones()[i]
        }
        return sum
    }
}